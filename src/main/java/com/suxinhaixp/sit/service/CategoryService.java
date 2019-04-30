package com.suxinhaixp.sit.service;

import com.suxinhaixp.sit.entity.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne (Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
