package com.suxinhaixp.sit;

import com.suxinhaixp.sit.dao.ProductCategoryRepository;
import com.suxinhaixp.sit.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SitApplicationTests {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Test
    public void contextLoads() {
    }

    @Test
    public  void test(){
        ProductCategory productCategory= productCategoryRepository.findByCategoryId(1);
        System.out.println(productCategory);
    }


}
