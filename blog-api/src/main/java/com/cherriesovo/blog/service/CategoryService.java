package com.cherriesovo.blog.service;

import com.cherriesovo.blog.vo.CategoryVo;
import com.cherriesovo.blog.vo.Result;

import java.util.List;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();   //类别查询

    Result findAllDetail(); //文章分类

    Result categoriesDetailById(Long id);
}
