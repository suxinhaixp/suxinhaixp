package com.suxinhaixp.sit.dao;

import com.suxinhaixp.sit.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory findByCategoryId(Integer id);
}
