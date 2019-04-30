package com.suxinhaixp.sit.config;


import com.suxinhaixp.sit.config.interceptor.HomeInterceptor;
import com.suxinhaixp.sit.config.interceptor.LoginHandlerInterceptor;
import com.suxinhaixp.sit.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
    }
    @Bean
    public LocaleResolver localeResolver()
    {
        return new MylocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/druid/*","/IsManager","/","/login","/index");
//        registry.addInterceptor(new HomeInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/","/login","/IsManager","/druid/*");
    }
    @Bean
    public LoginHandlerInterceptor authenticationInterceptor() {
        return new LoginHandlerInterceptor();
    }
}
//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
//        WebMvcConfigurerAdapter  adapter = new WebMvcConfigurerAdapter()
//        {
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login","/IsManager");
//            }
//        };
//    return  adapter;
//    }