package com.uax.accesodatos.AppFutbolApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JugadoresService {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

}
