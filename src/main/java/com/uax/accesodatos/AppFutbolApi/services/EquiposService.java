package com.uax.accesodatos.AppFutbolApi.services;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.repositories.EquiposRepository;
import com.uax.accesodatos.AppFutbolApi.repositories.JugadoresRepository;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Service
public class EquiposService {
	
	@Autowired
	AppFutbolUtils utils;
	    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    EquiposRepository equiposrepository;
    
    private final String urlEquiposApi = "https://v3.football.api-sports.io/teams?id=?";
    
    public EquiposResponseDTO getEquiposFromApi() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        // Construir la URL de la API
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://v3.football.api-sports.io/teams");

        // Agregar los parámetros de consulta necesarios a la URL
        builder.queryParam("search", "Spain");

        // Agregar los encabezados necesarios a la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "ae76f089a66a76dafc4e958eab705477");
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        // Crear una instancia de HttpEntity con los encabezados necesarios
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // Realizar la solicitud HTTP
        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        // Analizar la respuesta JSON en objetos Java utilizando un ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(response.getBody(), Root.class);

        // Obtener la lista de equipos y filtrarla por país
        List<EquiposDTO> equipos = root.getResponse().stream()
                .filter(r -> r.getTeam().getCountry().equals("Spain"))
                .map(r -> {
                    EquiposDTO equipo = new EquiposDTO();
                    equipo.setNombre(r.getTeam().getName());
                    equipo.setPais(r.getTeam().getCountry());
                    equipo.setUrlfoto(r.getTeam().getLogo());
                    return equipo;
                })
                .collect(Collectors.toList());

        // Crear y devolver un objeto EquiposResponseDTO con la lista de equipos
        EquiposResponseDTO equiposResponseDTO = new EquiposResponseDTO();
        equiposResponseDTO.setResponse(equipos);
        return equiposResponseDTO;
    }

    public List<EquiposDTO> findAll() {
    	
        return equiposrepository.findAll();
        
    }

	public boolean addEquiposFavoritos(EquiposDTO equipo){
		
		equiposrepository.saveEquipo(equipo);
		
		return true;
	}
	
	public boolean deleteEquiposFavoritos(int id){
		
		equiposrepository.deleteEquipo(id);
		
		return true;
	}
	
	public List<EquiposDTO> getListaFavoritos() throws IOException{
		
		return equiposrepository.findAll();
		
		
	}
}
