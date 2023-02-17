package com.uax.accesodatos.AppFutbolApi.services;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    
    
    //convertir de objeto API a DTO
    
    public List<EquiposDTO>convertirObjetoApiToDTO(Root root) {
    	ArrayList<EquiposDTO> equipos= new ArrayList<EquiposDTO>();
    	
    	for (Response response : root.getResponse()) {
    		Team equipo=response.getTeam();
			EquiposDTO parametros= new EquiposDTO();
			parametros.setId(equipo.getId());
			parametros.setUrlfoto(equipo.getLogo());
			parametros.setNombre(equipo.getName());
			parametros.setPais(equipo.getCountry());
			
			
			equipos.add(parametros);
		}
    	
    	
    	return equipos;
    }
   
    public ArrayList<EquiposDTO> getEquipos() throws IOException {
        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        
        String jsonResponse = utils.readFile("responseTeams.json");

		Gson gson= new Gson();
		Root root=gson.fromJson(jsonResponse, Root.class);
        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTO(root);

        return equipos;
    }

    //getEquipos()
    //2 metodos, uno con la conexion con la api, con el root, y root hay que pasarlo al metodo de convertir dto para que de 
    //root te pase a una arraylist para que te pase a una ArraylistDTO y luego se pasa al controller
    //Service se encagarga de recuperar toda la información de la API
    
    public List<EquiposDTO> findAll() {
    	
        return equiposrepository.findAll();
        
    }

}
