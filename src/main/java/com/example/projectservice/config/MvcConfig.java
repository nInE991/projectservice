package com.example.projectservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/service").setViewName("service");
		registry.addViewController("/tracking").setViewName("tracking");
		registry.addViewController("/contact").setViewName("contact");
		registry.addViewController("/login").setViewName("login");


		registry.addViewController("/director").setViewName("/director/index");
		registry.addViewController("/admin").setViewName("/admin/index");
	}
}
