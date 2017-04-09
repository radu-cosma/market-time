package com.markettime;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cloudinary.Cloudinary;
import com.markettime.handler.NoCacheFilter;

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
public class MarketTimeApplication {

    @Value("${cloudinary.cloud.name}")
    private String cloudName;

    @Value("${cloudinary.api.key}")
    private String apiKey;

    @Value("${cloudinary.api.secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> cloudinaryConfig = new HashMap<>();
        cloudinaryConfig.put("cloud_name", cloudName);
        cloudinaryConfig.put("api_key", apiKey);
        cloudinaryConfig.put("api_secret", apiSecret);
        return new Cloudinary(cloudinaryConfig);
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Filter noCacheFilter() {
        return new NoCacheFilter();
    }

    // @Bean
    // public InstrumentationLoadTimeWeaver loadTimeWeaver() {
    // return new InstrumentationLoadTimeWeaver();
    // }

    public static void main(String[] args) {
        SpringApplication.run(MarketTimeApplication.class, args);
    }

}
