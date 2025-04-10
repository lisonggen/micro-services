package com.lisg.goods.service;

import com.lisg.goods.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategorys(Integer parentId);
}
