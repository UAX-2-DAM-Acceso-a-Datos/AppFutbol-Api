package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;
import com.uax.accesodatos.AppFutbolApi.mapper.EstadiosRowMapper;

@Repository
public class EstadiosRepository implements EstadiosInterface{

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<EstadiosDTO> getAllEstadios() {
		return jdbctemplate.query("SELECT id, nombre, ciudad, capacidad, "
				+ "urlfoto, equipo FROM estadios", 
				new EstadiosRowMapper());
	}

	@Override
	public boolean saveEstadio(EstadiosDTO estadio) {
	    String sql = "INSERT INTO estadios (id, nombre, ciudad, capacidad, urlfoto, equipo) VALUES ('%d','%s','%d','%d','%s', 0)";
	    String sqlMapeado = String.format(sql, estadio.getId(), estadio.getName(), estadio.getAddress(), estadio.getCapacity(), estadio.getImage());
	    jdbctemplate.execute(sqlMapeado);
	    return true;
	}

	@Override
	public boolean deleteEstadio(int id) {
	    String sql = "DELETE FROM estadios WHERE id = ?";
	    int rowCount = jdbctemplate.update(sql, id);
	    return rowCount > 0;
	}
}
