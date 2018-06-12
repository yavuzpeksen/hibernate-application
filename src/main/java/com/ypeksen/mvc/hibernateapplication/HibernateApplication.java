package com.ypeksen.mvc.hibernateapplication;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.ypeksen.mvc")
public class HibernateApplication implements WebMvcConfigurer{

	@Bean  
  public InternalResourceViewResolver viewResolver() {  
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
    resolver.setPrefix("/WEB-INF/jsp/");  
    resolver.setSuffix(".jsp");
    return resolver;  
  }
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		//registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		//registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/")
    .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
}