package com.rps.restservicecors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RestServiceCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceCorsApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting").allowedOrigins("http://localhost:8080", "http://localhost:4200");
			}
		};
	}
}
