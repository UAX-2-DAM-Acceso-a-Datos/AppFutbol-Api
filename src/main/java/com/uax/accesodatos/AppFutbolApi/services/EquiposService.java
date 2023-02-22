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
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.Root;
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
    
    
    
    
    
    
//    //Recuperar datos por búsqueda usando la API
//    private final String urlEquiposApi = "https://v3.football.api-sports.io/teams?search=%Busqueda%";
//    
//    public JugadoresDTO getEquipoPorNombre(String nombre) throws IOException {
//    	
//        ArrayList<EquiposDTO> equipos = new ArrayList<>();
//        
//        String jsonResponse = utils.readFile("responsePlayers.json");
//        
//        Gson gson = new Gson();
//        Root root = gson.fromJson(jsonResponse, Root.class);
//        equipos = (ArrayList<EquiposDTO>) convertirObjetoApitoDTO(root);
//        
//        for (EquiposDTO equipo: equipos) {
//            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
//                return equipo;
//            }
//        }
//        
//        return null;
//    }

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
