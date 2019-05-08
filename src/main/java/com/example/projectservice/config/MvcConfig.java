package com.example.projectservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/service").setViewName("service");
		registry.addViewController("/tracking").setViewName("tracking");
		registry.addViewController("/contact").setViewName("contact");
		registry.addViewController("/login").setViewName("login");

//		registry.addViewController("/accessDeny").setViewName("access");
		registry.addViewController("/director").setViewName("/director/index");
		registry.addViewController("/admin").setViewName("/admin/index");
		registry.addViewController("/manager").setViewName("/manager/index");
		registry.addViewController("/employees").setViewName("/employees/index");
	}
}
