package com.odk3.projet_tp_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetTpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetTpApiApplication.class, args);
		System.out.println("Application lancée avec succès!!!");
	}

}
