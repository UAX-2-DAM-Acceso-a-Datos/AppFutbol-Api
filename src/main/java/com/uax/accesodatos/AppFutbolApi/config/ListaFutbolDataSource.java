package com.uax.accesodatos.AppFutbolApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ListaFutbolDataSource {
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
