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
import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.Root;
import com.uax.accesodatos.AppFutbolApi.repositories.EquiposRepository;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Service
public class EquiposService {
	
	@Autowired
	AppFutbolUtils utils;
	   
    
    @Autowired
    EquiposRepository equiposrepository;
    
    
//Recuperar datos usando JSON 
    public List<EquiposDTO> convertirObjetoApiToDTO(Root root) {
        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        for (Response response : root.getResponse()) {
            Team equipo = response.getTeam();
            EquiposDTO parametros = new EquiposDTO();
            parametros.setId(equipo.getId());
            parametros.setUrlfoto(equipo.getLogo());
            parametros.setNombre(equipo.getName());
            parametros.setPais(equipo.getCountry());
            equipos.add(parametros);
        }
        return equipos;
    }
    
    //Obtener equipos
    public ArrayList<EquiposDTO> getEquipos() throws IOException {
        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        String jsonResponse = utils.readFile("responseTeams.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);
        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTO(root);
        return equipos;
    }

    //Obtener equipos por nombres   
    public EquiposDTO getEquipoPorNombre(String nombre) throws IOException {
        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        String jsonResponse = utils.readFile("responsePlayers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);
        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTO(root);
        for (EquiposDTO equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
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
    
    
    
//    //Recuperar datos por búsqueda usando la API
//    private final String urlEquiposApi = "https://v3.football.api-sports.io/teams?search=%Busqueda%";
//    
//    public JugadoresDTO getEquipoPorNombre(String nombre) throws IOException {
//    	
//        ArrayList<EquiposDTO> equipos = new ArrayList<>();
//        
//        String jsonResponse = utils.readFile("responseTeams.json");
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

}
