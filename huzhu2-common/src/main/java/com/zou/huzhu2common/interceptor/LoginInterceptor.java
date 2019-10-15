package com.zou.huzhu2common.interceptor;

import com.alibaba.fastjson.JSON;
import com.zou.huzhu2common.utils.ErrorCode;
import com.zou.huzhu2common.utils.JwtUtils;
import com.zou.huzhu2common.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 21:20
 * Project:  huzhu
 * Description:
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        if (null == token || StringUtils.isBlank(token)){
            result(response);
            return false;
        }else if (token.equals("newUser")){
            return true;
        }
        String loginId = request.getHeader("loginId");
        if (null != loginId){
            String tokenLoginId = JwtUtils.unsign(token, String.class);
            if (null != tokenLoginId && tokenLoginId.equals(loginId)){
                return true;
            }
        }
        result(response);
        return false;
    }

    private void result(HttpServletResponse response) {
        Response resp = Response.error(ErrorCode.USER_AUTHORIZATION_FAILED);
        String json = JSON.toJSONString(resp);
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(401);
        try {
            ServletOutputStream stream = response.getOutputStream();
            stream.write(json.getBytes());
            stream.flush();
//            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
