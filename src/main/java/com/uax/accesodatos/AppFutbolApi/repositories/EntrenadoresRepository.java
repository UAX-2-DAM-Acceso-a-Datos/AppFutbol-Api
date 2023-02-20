package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.uax.accesodatos.AppFutbolApi.controller.EntrenadoresController;
import com.uax.accesodatos.AppFutbolApi.dto.EntrenadoresDTO;


public class EntrenadoresRepository implements IEntrenadoresRepository{


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<EntrenadoresDTO> findAll() {
        String sql = "SELECT id, nombre, edad, nacionalidad, urlfoto, equipo FROM entrenadores";
        List<EntrenadoresDTO> entrenadores = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EntrenadoresDTO.class));
        return entrenadores;
	}
	
	public boolean saveEntrenadores(EntrenadoresDTO entrenadores) {
		try {

			String sql = String.format(
					"INSERT INTO Entrenadores (id, nombre, edad, nacionalidad, urlfoto, equipo) VALUES('%d'"
					+ ",'%s','%s','%s','%s','%d')", entrenadores.getId(), entrenadores.getName(), entrenadores.getAge(), 
					entrenadores.getCountry(), entrenadores.getUrlimage(), entrenadores.getIdTeam());
			jdbcTemplate.execute(sql);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
