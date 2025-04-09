package com.lisg.search.controller;

import com.lisg.search.entity.elasticsearch.SkuDocument;
import com.lisg.search.service.SkuSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* @program: micro-services
*
* @description:
*
* @author: Reagan Li
*
* @create: 2025-04-09 10:19
**/

@Tag(name = "SpuSearchController", description = "Spu Search Controller")
@RestController
@RequestMapping("/search/spu")
public class SpuSearchController {

    @Autowired
    private SkuSearchService spuSearchService;

    @Operation(summary = "Search", description = "Search")
    @GetMapping
    public List<SkuDocument> search(@RequestParam("keyword") String keyword,
                                    @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<SkuDocument> search = spuSearchService.search(keyword, pageNo, pageSize);
        return search;
    }

    @Operation(summary = "import data", description = "import")
    @PostMapping("/import")
    public String importSku(@RequestParam("id") String id) {
        spuSearchService.importSkuById(id);
        return "ok";
    }
}
