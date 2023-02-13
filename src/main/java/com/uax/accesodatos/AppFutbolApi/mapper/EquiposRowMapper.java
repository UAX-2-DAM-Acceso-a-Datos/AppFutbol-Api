package com.uax.accesodatos.AppFutbolApi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uax.accesodatos.AppFutbolApi.dto.EquiposDTO;

public class EquiposRowMapper implements RowMapper<EquiposDTO>{

	@Override
	public EquiposDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EquiposDTO equipo = new EquiposDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("season"),
                rs.getString("country"),
                rs.getString("logo"),
                rs.getString("urlimage"),
                rs.getString("venue")
            );
            return equipo;
	}

}
