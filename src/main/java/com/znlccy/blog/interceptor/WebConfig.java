package com.znlccy.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-28-10:05
 * @remark: 服务配置类
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 过滤拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}
