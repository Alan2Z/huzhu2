package com.zou.huzhu2common.config;

import com.zou.huzhu2common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Author:   Guangyu Zou
 * DateTime: 2019/8/31 21:33
 * Project:  huzhu
 * Description:
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/login/token");
        super.addInterceptors(registry);
    }
}
