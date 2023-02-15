package com.uax.accesodatos.AppFutbolApi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Service
public class JugadoresService {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
	AppFutbolUtils utils;
    
    @Autowired
    private RestTemplate restTemplate;
    public List<JugadoresDTO> findAll() {
        String sql = "SELECT * FROM jugadores";
        List<JugadoresDTO> jugadores = jdbcTemplate.query(sql, new RowMapper<JugadoresDTO>() {
            @Override
            public JugadoresDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            	JugadoresDTO jugador = new JugadoresDTO(
                    rs.getString("id"),
                    rs.getString(""),
                );
                return jugador;
            }
        });
        return jugadores;
    }

}
