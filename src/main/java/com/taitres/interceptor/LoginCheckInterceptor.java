package com.taitres.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.taitres.pojo.Result;
import com.taitres.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //      1.获取请求路径
        //      2.判断是否是登录相关的路径
        //      3.如果是，放行
        //      4.如果不是，判断是否登录
        //      5.如果登录，放行


        String token = request.getHeader("token");
        if (!StringUtils.hasLength(token)){
            log.info("未登录，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        log.info("已登录，放行");
        return true;

    }



}
