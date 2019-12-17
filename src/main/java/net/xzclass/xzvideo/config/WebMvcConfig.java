package net.xzclass.xzvideo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.xzclass.xzvideo.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("images/**").addResourceLocations("/my/xzclass/images");
		registry.addResourceHandler("images/**").addResourceLocations("D:\\local\\data\\xzclass\\images");
	}

	/**
	 * 	拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
			.addPathPatterns("/user/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
}
