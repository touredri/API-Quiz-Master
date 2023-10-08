package com.odk3.projet_tp_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetTpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetTpApiApplication.class, args);
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOrigins(List.of("http://localhost:9090"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		configuration.setMaxAge(3600L);
		configuration.setAllowedHeaders(List.of("All"));

		return new UrlBasedCorsConfigurationSource();
	}
}
