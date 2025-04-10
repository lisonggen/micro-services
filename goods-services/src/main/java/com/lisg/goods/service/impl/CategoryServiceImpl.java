package com.lisg.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lisg.goods.mapper.CategoryMapper;
import com.lisg.goods.model.entity.Category;
import com.lisg.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 15:55
 **/

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategorys(Integer parentId) {
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        if (parentId == null) {
            categoryQueryWrapper.eq("parent_id", 0);
        } else {
            categoryQueryWrapper.eq("parent_id", parentId);
        }
        categoryQueryWrapper.orderByAsc("id");
        List<Category> categories = categoryMapper.selectList(categoryQueryWrapper);
        return categories;
    }

}
