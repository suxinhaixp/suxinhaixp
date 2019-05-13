//package com.suxinhaixp.sit.component;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.servlet.View;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//
//import java.io.IOException;
//import java.util.Locale;
//
//public class MyThymleafResolver extends ThymeleafViewResolver {
//
//    @Value("${spring.thymleaf.prefix}")
//    private  String prefix;
//
//    @Value("${spring.thymleaf.suffix}")
//    private String suffix;
//
//    @Override
//    protected View loadView(String viewName, Locale locale) throws Exception {
//        String resourceName=prefix + viewName +suffix;
//        try {
//            this.getApplicationContext().getResource(resourceName).getInputStream();
//        }catch (final IOException e){
//            if(logger.isDebugEnabled()){
//                logger.trace("视图名不存在");
//            }
//            else {
//                logger.trace("视图名不存在");
//            }
//            return  null;
//        }
//    return super.loadView(viewName,locale);
//    }
//}
