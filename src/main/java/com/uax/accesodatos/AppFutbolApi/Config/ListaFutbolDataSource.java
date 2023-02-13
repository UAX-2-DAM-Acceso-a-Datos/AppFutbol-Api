package com.uax.accesodatos.AppFutbolApi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class ListaFutbolDataSource {
	
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
