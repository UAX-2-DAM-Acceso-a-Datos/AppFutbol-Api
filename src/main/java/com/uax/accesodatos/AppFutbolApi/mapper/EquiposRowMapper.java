package com.uax.accesodatos.AppFutbolApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

public class EquiposRowMapper implements RowMapper<EquiposDTO>{

	@Override
	public EquiposDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EquiposDTO equipo = new EquiposDTO(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("pais"),
                rs.getString("urlfoto"),
                rs.getString("estadio")
            );
            return equipo;
	}

}
