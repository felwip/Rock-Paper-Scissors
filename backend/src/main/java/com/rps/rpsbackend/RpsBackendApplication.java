package com.rps.rpsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RpsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpsBackendApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api")
						.allowedOrigins("http://localhost:4200", "http://localhost:34200")
						.allowedMethods("POST", "GET");
			}
		};
	}
}
