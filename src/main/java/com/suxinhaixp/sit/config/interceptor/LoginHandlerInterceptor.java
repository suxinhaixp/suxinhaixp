package com.suxinhaixp.sit.config.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.service.Imp.ManagerServiceImpl;
import com.suxinhaixp.sit.token.PassToken;
import com.suxinhaixp.sit.token.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;


public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private ManagerServiceImpl managerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");// 从 http 请求头中取出 token
//        String token=request.getParameter("token");
        if(token!=null) {
            System.out.println(JWT.decode(token).getExpiresAt());
        }
        Date date= new Date(System.currentTimeMillis());
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
            if (date.getTime()>(JWT.decode(token).getExpiresAt()).getTime()) {
                response.sendRedirect("/");
                System.out.println("无token，请重新登录");
                return false;
            }

//        System.out.println(JWT.decode(token).getAudience().toString());
        String managerId = "";
        // 如果不是映射到方法直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    response.sendRedirect("/");
                    System.out.println("无token，请重新登录");
                    return  false;
                }
//                 获取 token 中的 manager id
                try {
                    managerId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    response.sendRedirect("/");
                    return  false;
                }

                
                Manager manager = managerService.findByUsername(managerId);
                if (manager == null) {
                    response.sendRedirect("/");
                    System.out.println("用户不存在，请重新登录");
                    return  false;
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(manager.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    response.sendRedirect("/");
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
