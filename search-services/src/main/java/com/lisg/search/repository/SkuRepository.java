package com.lisg.search.repository;

import com.lisg.search.entity.elasticsearch.SkuDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SkuRepository extends ElasticsearchRepository<SkuDocument, String> {

    List<SkuDocument> findByName(String keyword, Pageable pageable);
}
