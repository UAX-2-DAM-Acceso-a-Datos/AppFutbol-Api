package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

@Service
public class EquiposRepository implements IEquiposRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    //Método para consultar los equipos
	@Override
	public List<EquiposDTO> findAll() {
        String sql = "SELECT id, nombre, pais, urlfoto FROM equipos";
        List<EquiposDTO> equipos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(EquiposDTO.class));
        return equipos;
	}
	//Método para guardar los equipos
	@Override
	public boolean saveEquipo(EquiposDTO equipo) {
	    String sql = "INSERT INTO equipos (nombre, pais, urlfoto) VALUES (?, ?, ?)";
	    int rowCount = jdbcTemplate.update(sql, equipo.getNombre(), equipo.getPais(), equipo.getUrlfoto());
	    return rowCount > 0;
	}
	//Método para borrar los equipos
	@Override
	public boolean deleteEquipo(int id) {
	    String sql = "DELETE FROM equipos WHERE id = ?";
	    int rowCount = jdbcTemplate.update(sql, id);
	    return rowCount > 0;
	}

	

}
