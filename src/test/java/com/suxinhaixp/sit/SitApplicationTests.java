package com.suxinhaixp.sit;



import com.suxinhaixp.sit.entity.ProductInfo;
import com.suxinhaixp.sit.service.Imp.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SitApplicationTests   {
@Autowired
    ProductServiceImpl productService;

    @Test
    public void findProductInfoById(){

        //多线程，该线程调用底层根据id查询学生的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                productService.findOne("1558676343959365244");
            }
        };
        //多线程测试高并发条件下内网穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25); //线程池根据CPU来选择适当的值
        for (int i = 0; i < 10000; i++) {
            //提交线程runnable方法
            executorService.submit(runnable);
        }

        ProductInfo productInfo = productService.findOne("1558676343959365244");
        System.out.println(productInfo);
    }





}
