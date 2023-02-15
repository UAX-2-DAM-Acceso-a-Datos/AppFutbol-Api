package com.uax.accesodatos.AppFutbolApi.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Service
public class EquiposService {
	
	    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private RestTemplate restTemplate;
    public List<EquiposDTO> findAll() {
        String sql = "SELECT * FROM equipos";
        List<EquiposDTO> equipos = jdbcTemplate.query(sql, new RowMapper<EquiposDTO>() {
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
        });
        return equipos;
    }
    public List<EquiposDTO> buscarEquipos(String busqueda) {
        String url = "https://v3.football.api-sports.io/teams?search=%s" + busqueda;
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");
        headers.set("x-rapidapi-key", "562a0587497cee9a309f88f5c8bcb789");

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<EquiposResponseDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, EquiposResponseDTO.class);

        EquiposResponseDTO equiposResponse = responseEntity.getBody();
        List<EquiposDTO> equipos = equiposResponse.getData();
        return equipos;
    }
}
