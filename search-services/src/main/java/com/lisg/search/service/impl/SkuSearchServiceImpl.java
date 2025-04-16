package com.lisg.search.service.impl;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import com.lisg.goods.dto.SkuDTO;
import com.lisg.goods.feign.GoodsFeign;
import com.lisg.search.entity.elasticsearch.SkuDocument;
import com.lisg.search.repository.SkuRepository;
import com.lisg.search.service.SkuSearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-09 10:22
 **/

@Service
public class SkuSearchServiceImpl implements SkuSearchService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private SkuRepository spuRepository;

    @Autowired
    private GoodsFeign goodsFeign;

    @Override
    public List<SkuDocument> search(String keyword, int pageNo, int pageSize) {
        NativeQuery nativeQuery = NativeQuery.builder()
                .withAggregation("brandName", Aggregation.of(a -> a.terms(ta -> ta.field("brandName").size(10))))
                .withQuery(q -> q.match(m -> m.field("name").query(keyword)))
                .withPageable(PageRequest.of(pageNo, pageSize)).build();

        SearchHits<SkuDocument> searchHits = elasticsearchOperations.search(nativeQuery, SkuDocument.class);
        List<SkuDocument> spuDocuments = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return spuDocuments;
    }

    @Override
    public void importSkuById(String id) {
        SkuDTO skuDTO = goodsFeign.getSkuById(id).getData();
        SkuDocument skuDocument = new SkuDocument();
        BeanUtils.copyProperties(skuDTO, skuDocument);
        spuRepository.save(skuDocument);
    }

}
