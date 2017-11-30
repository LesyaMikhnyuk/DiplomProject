package com.my.util;

import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.AnnotationDrivenBeanDefinitionParser;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import  org.springframework.web.servlet.config.annotation.EnableWebMvc;
import  org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver viewResolver(){

        AnnotationDrivenBeanDefinitionParser dr = new AnnotationDrivenBeanDefinitionParser();
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
