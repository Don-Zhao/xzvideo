package net.xzclass.xzvideo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("images/**").addResourceLocations("/my/xzclass/images");
		registry.addResourceHandler("images/**").addResourceLocations("D:\\local\\data\\xzclass\\images");
	}

}
