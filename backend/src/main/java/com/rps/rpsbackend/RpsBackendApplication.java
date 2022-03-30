package com.rps.rpsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@SpringBootApplication
public class RpsBackendApplication {

	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(RpsBackendApplication.class, args);

		/* ! For testing the log4j implementation. Currently not working!
		logger.debug("It is a debug logger.");
		logger.error("It is an error logger.");
		logger.fatal("It is a fatal logger.");
		logger.info("It is a info logger.");
		logger.trace("It is a trace logger.");
		logger.warn("It is a warn logger.");
		 */

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("POST", "GET");
			}
		};
	}
}
