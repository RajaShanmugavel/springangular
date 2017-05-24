package com.abc.springmvc.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.abc.springmvc")
public class MyAppConfiguration extends WebMvcConfigurerAdapter {
	
	
	@Bean
    public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
 
        Properties exceptionMappings = new Properties();
 
        exceptionMappings.put("java.lang.Exception", "error/error");
        exceptionMappings.put("java.lang.RuntimeException", "error/error");
 
        exceptionResolver.setExceptionMappings(exceptionMappings);
 
        Properties statusCodes = new Properties();
 
//        statusCodes.put("error/404", "404");
        statusCodes.put("error/error", "500");
 
        exceptionResolver.setStatusCodes(statusCodes);
 
        return exceptionResolver;
    }
	
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

}
