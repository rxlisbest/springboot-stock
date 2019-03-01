package com.ruiruisun.stock.config;

import com.ruiruisun.stock.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor localLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/index");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}