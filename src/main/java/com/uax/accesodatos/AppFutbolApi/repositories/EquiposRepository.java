package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

public class EquiposRepository implements IEquiposRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EquiposDTO> findAll() {
        String sql = "SELECT id, nombre, liga, pais, urlfoto, estadio FROM equipos";
        List<EquiposDTO> equipos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EquiposDTO.class));
        return equipos;
	}

}
