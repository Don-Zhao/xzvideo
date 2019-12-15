package net.xzclass.xzvideo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("net.xzclass.xzvideo.mapper")
public class XzvideoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(XzvideoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XzvideoApplication.class);
	}
}
