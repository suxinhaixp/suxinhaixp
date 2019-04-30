package com.suxinhaixp.sit.service.Imp;

import com.suxinhaixp.sit.dao.ProductCategoryRepository;
import com.suxinhaixp.sit.entity.ProductCategory;
import com.suxinhaixp.sit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository Repository;


    @Override
    public ProductCategory findOne(Integer id) {
        return Repository.findByCategoryId(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return Repository.findAll();

    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList) {
        return Repository.findByCategoryTypeIn(CategoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return Repository.save(productCategory);
    }
}
