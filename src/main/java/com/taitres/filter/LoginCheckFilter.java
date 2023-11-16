package com.taitres.filter;

import com.alibaba.fastjson.JSONObject;
import com.taitres.pojo.Result;
import com.taitres.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.StringUtils;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        1.获取请求路径
//        2.判断是否是登录相关的路径
//        3.如果是，放行
//        4.如果不是，判断是否登录
//        5.如果登录，放行
        HttpServletRequest Request = (HttpServletRequest) servletRequest;
        HttpServletResponse Response = (HttpServletResponse) servletResponse;
        String url = Request.getRequestURL().toString();

        if (url.contains("login")){
            log.info("登录相关的路径，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = Request.getHeader("token");
        if (!StringUtils.hasLength(token)){
            log.info("未登录，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            Response.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            Response.getWriter().write(notLogin);
            return;
        }

        log.info("已登录，放行");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
