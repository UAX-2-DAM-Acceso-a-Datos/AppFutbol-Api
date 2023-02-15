package com.uax.accesodatos.AppFutbolApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AppFutbolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppFutbolApiApplication.class, args);
	}

}
