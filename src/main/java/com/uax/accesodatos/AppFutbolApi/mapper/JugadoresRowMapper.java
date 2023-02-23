package com.uax.accesodatos.AppFutbolApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;

public class JugadoresRowMapper implements RowMapper<JugadoresDTO>{

	@Override
	public JugadoresDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		JugadoresDTO jugador = new JugadoresDTO(
				rs.getInt("id"),
				rs.getString("nombre"),
				rs.getInt("edad"),
				rs.getString("nacionalidad"),
				rs.getString("urlfoto"),
				rs.getInt("equipo")
				);
		return jugador;
	}

}
