package com.lisg.search.service;

import com.lisg.search.entity.elasticsearch.SkuDocument;

import java.util.List;

public interface SkuSearchService {

    List<SkuDocument> search(String keyword, int pageNo, int pageSize);

    void importSkuById(String id);
}
