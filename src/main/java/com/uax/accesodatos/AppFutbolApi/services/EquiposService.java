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
import org.springframework.http.MediaType;
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
    
    private final String urlEquiposApi = "https://v3.football.api-sports.io/teams?id=?";
    
    //Obtener Equipos desde la API
    public EquiposResponseDTO getEquiposFromApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");
        headers.set("x-rapidapi-key","ae76f089a66a76dafc4e958eab705477");

        String urlEquiposApi = "https://v3.football.api-sports.io/teams";

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<EquiposResponseDTO> response = restTemplate.exchange(urlEquiposApi, HttpMethod.GET, entity, EquiposResponseDTO.class);

        return response.getBody();
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
    
    
//    //convertir de objeto API a DTO
//    
//    public List<EquiposDTO>convertirObjetoApiToDTO(Root root) {
//    	ArrayList<EquiposDTO> equipos= new ArrayList<EquiposDTO>();
//    	
//    	for (Response response : root.getResponse()) {
//    		Team equipo=response.getTeam();
//			EquiposDTO parametros= new EquiposDTO();
//			parametros.setId(equipo.getId());
//			parametros.setUrlfoto(equipo.getLogo());
//			parametros.setNombre(equipo.getName());
//			parametros.setPais(equipo.getCountry());
//			
//			
//			equipos.add(parametros);
//		}
//    	
//    	return equipos;
//    }
//   
//    public ArrayList<EquiposDTO> getEquipos() throws IOException {
//        ArrayList<EquiposDTO> equipos = new ArrayList<>();
//        
//        String jsonResponse = utils.readFile("responseTeams.json");
//
//		Gson gson= new Gson();
//		Root root=gson.fromJson(jsonResponse, Root.class);
//        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTO(root);
//
//        return equipos;
//    }



}
