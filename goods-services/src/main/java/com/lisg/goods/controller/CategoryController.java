package com.lisg.goods.controller;

import com.lisg.common.response.ResponseResult;
import com.lisg.goods.model.entity.Category;
import com.lisg.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 15:50
 **/

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseResult selectCategory(@RequestParam(name = "parentId", required = false) Integer parentId) {
        List<Category> categorys = categoryService.getCategorys(parentId);
        return ResponseResult.success(categorys);
    }
}
