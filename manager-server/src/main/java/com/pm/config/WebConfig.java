package com.pm.config;

import com.pm.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public UserInterceptor getUserInter(){
        return new UserInterceptor();
}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(getUserInter()).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/docs.html")
                .excludePathPatterns("/swagger-ui.html");
    }

}
