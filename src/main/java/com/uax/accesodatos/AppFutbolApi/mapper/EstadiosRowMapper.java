package com.uax.accesodatos.AppFutbolApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;

public class EstadiosRowMapper implements RowMapper<EstadiosDTO>{

	@Override
	public EstadiosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		EstadiosDTO estadio = new EstadiosDTO();
		estadio.setId(rs.getInt(1));
		estadio.setName(rs.getString(2));
		estadio.setCity(rs.getString(3));
		estadio.setCapacity(rs.getInt(4));
		estadio.setImage(rs.getString(5));
		return estadio;
	}

}
