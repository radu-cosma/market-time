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

    private static final String FONTS_MAPPING = "fonts/**";
    private static final String FONTS_LOCATION = "classpath:/static/fonts/";

    private static final String IMAGES_MAPPING = "images/**";
    private static final String IMAGES_LOCATION = "classpath:/static/images/";

    private static final String SCRIPTS_MAPPING = "scripts/**";
    private static final String SCRIPTS_LOCATION = "classpath:/static/scripts/";

    private static final String STYLES_MAPPING = "styles/**";
    private static final String STYLES_LOCATION = "classpath:/static/styles/";

    @Autowired
    private UserContextInterceptor userContextInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern(FONTS_MAPPING)) {
            registry.addResourceHandler(FONTS_MAPPING).addResourceLocations(FONTS_LOCATION);
        }
        if (!registry.hasMappingForPattern(IMAGES_MAPPING)) {
            registry.addResourceHandler(IMAGES_MAPPING).addResourceLocations(IMAGES_LOCATION);
        }
        if (!registry.hasMappingForPattern(SCRIPTS_MAPPING)) {
            registry.addResourceHandler(SCRIPTS_MAPPING).addResourceLocations(SCRIPTS_LOCATION);
        }
        if (!registry.hasMappingForPattern(STYLES_MAPPING)) {
            registry.addResourceHandler(STYLES_MAPPING).addResourceLocations(STYLES_LOCATION);
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
