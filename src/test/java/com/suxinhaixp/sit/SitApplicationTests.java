package com.suxinhaixp.sit;

import com.suxinhaixp.sit.dao.OrderMasterRepository;
import com.suxinhaixp.sit.dao.ProductCategoryRepository;
import com.suxinhaixp.sit.entity.OrderMaster;
import com.suxinhaixp.sit.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SitApplicationTests {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    OrderMasterRepository repository;
    @Test
    public void contextLoads() {
    }

    @Test
    public  void selecet(){
        ProductCategory productCategory= productCategoryRepository.findByCategoryId(1);
        System.out.println(productCategory);
    }

    @Test
    public void save()
    {
        ProductCategory productCategory=productCategoryRepository.findByCategoryId(1);

        productCategory.setCategoryType(10);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster =new OrderMaster();
        orderMaster.setOrderId("123432");
        orderMaster.setBuyerName("lisi");
        orderMaster.setBuyerAddress("bank");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerPhone("13918781547");
        orderMaster.setOrderAmount(new BigDecimal(5.4));
        repository.save(orderMaster);
    }




}
