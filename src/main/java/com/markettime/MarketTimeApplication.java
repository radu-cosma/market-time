package com.markettime;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cloudinary.Cloudinary;
import com.markettime.interceptor.UserContextInterceptor;
import com.markettime.web.servlet.view.CustomFreeMarkerViewResolver;

/**
 *
 * @author Radu Cosma
 *
 */
@Configuration
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableTransactionManagement
// @EnableLoadTimeWeaving
public class MarketTimeApplication extends WebMvcConfigurerAdapter {

    @Value("${cloudinary.cloud.name}")
    private String cloudName;

    @Value("${cloudinary.api.key}")
    private String apiKey;

    @Value("${cloudinary.api.secret}")
    private String apiSecret;

    @Autowired
    private UserContextInterceptor userContextInterceptor;

    // @Override
    // public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    // configurer.enable();
    // }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor).addPathPatterns("/**");
    }

    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // registry.addResourceHandler("*.css");
    // registry.addResourceHandler("*.js");
    // registry.addResourceHandler("*.png");
    // registry.addResourceHandler("*.svg");
    // registry.addResourceHandler("*.eot");
    // registry.addResourceHandler("*.ttf");
    // registry.addResourceHandler("*.woff");
    // registry.addResourceHandler("*.woff2");
    // }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(customFreeMarkerViewResolver());
        // registry.freeMarker();
    }

    @Bean
    public CustomFreeMarkerViewResolver customFreeMarkerViewResolver() {
        return new CustomFreeMarkerViewResolver();
    }

    // @Bean
    // public FreeMarkerConfigurer getFreeMarkerConfigurer() throws IOException, TemplateException {
    // FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    // Properties properties = new Properties();
    // properties.setProperty("auto_import", "spring.ftl as spring");
    // configurer.setFreemarkerSettings(properties);
    // return configurer;
    // }

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> cloudinaryConfig = new HashMap<>();
        cloudinaryConfig.put("cloud_name", cloudName);
        cloudinaryConfig.put("api_key", apiKey);
        cloudinaryConfig.put("api_secret", apiSecret);
        return new Cloudinary(cloudinaryConfig);
    }

    @Bean
    public ReloadableResourceBundleMessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(MarketTimeApplication.class, args);
    }

}
