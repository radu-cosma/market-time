package com.markettime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.markettime.interceptor.UserContextInterceptor;
import com.markettime.web.servlet.view.CustomFreeMarkerViewResolver;

/**
 *
 * @author Radu Cosma
 *
 */
@Configuration
@EnableWebMvc
public class MarketTimeMvcConfiguration extends WebMvcConfigurerAdapter {

    private static final String[] RESOURCE_LOCATIONS = { "classpath:/static/fonts", "classpath:/static/images",
            "classpath:/static/script", "classpath:/static/style" };

    @Autowired
    private UserContextInterceptor userContextInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
        }
    }

    @Bean
    public CustomFreeMarkerViewResolver customFreeMarkerViewResolver() {
        CustomFreeMarkerViewResolver customFreeMarkerViewResolver = new CustomFreeMarkerViewResolver();
        customFreeMarkerViewResolver.setOrder(1);
        customFreeMarkerViewResolver.setCache(false);
        customFreeMarkerViewResolver.setSuffix(".ftl");
        customFreeMarkerViewResolver.setExposeSpringMacroHelpers(true);
        return customFreeMarkerViewResolver;
    }

}
