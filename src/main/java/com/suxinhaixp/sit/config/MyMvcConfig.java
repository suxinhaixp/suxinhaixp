package com.suxinhaixp.sit.config;


//import com.suxinhaixp.sit.component.MyThymleafResolver;
import com.suxinhaixp.sit.component.MyFreeMarkerViewResolver;
import com.suxinhaixp.sit.component.MylocaleResolver;
import com.suxinhaixp.sit.config.interceptor.LoginHandlerInterceptor;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        MyFreeMarkerViewResolver resolver = new MyFreeMarkerViewResolver();
        resolver.setPrefix(null);
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setRequestContextAttribute("request");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        resolver.setOrder(1);
        return resolver;
    }


//    @Value("${spring.thymleaf.template-resolver-order}")
//    private int thymleafTemplateResolverOrder;
//
//    @Value("${spring.freemaker.template-resolver-order}")
//    private int freemarkerTemplateResolverOrder;

//    @Autowired
//    private FreeMarkerViewResolver freeMarkerViewResolver;
//
//    @Autowired
//    private ThymeleafViewResolver thymeleafViewResolver;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login.html");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MylocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/druid/*","/IsManager","/","/login","/index");
//        registry.addInterceptor(new HomeInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/","/login","/IsManager","/druid/*");
    }

    @Bean
    public LoginHandlerInterceptor authenticationInterceptor() {
        return new LoginHandlerInterceptor();
    }


//    @Bean
//    public ThymeleafViewResolver thymleafViewResolverBean() {
//        MyThymleafResolver myThymleafResolver = new MyThymleafResolver();
//        BeanUtils.copyProperties(thymeleafViewResolver, myThymleafResolver);
//        myThymleafResolver.setOrder(thymleafTemplateResolverOrder);
//        return myThymleafResolver;
//    }
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