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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
    
    private static final String API_URL = "https://v3.football.api-sports.io/teams";
    private static final String API_KEY = "95af3cd5edfeb7119cd7d3442536e507";
    
//Recuperar datos usando JSON 
//Convertir objeto api to dto para json

    public List<EquiposDTO> convertirObjetoApiToDTOJSON(Root root) {
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


    //Obtener equipos desde JSON
    public ArrayList<EquiposDTO> getEquiposJSON() throws IOException {

        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        String jsonResponse = utils.readFile("responseTeams.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);
        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTOJSON(root);
        return equipos;
    }


    //Obtiene equipo por nombre desde JSON
    public EquiposDTO getEquipoPorNombreJSON(String nombre) throws IOException {

        ArrayList<EquiposDTO> equipos = new ArrayList<>();
        String jsonResponse = utils.readFile("responsePlayers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);
        equipos = (ArrayList<EquiposDTO>) convertirObjetoApiToDTOJSON(root);
        for (EquiposDTO equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    //Obtener equipos desde la api API-SPORTS ACCOUNT
    public List<EquiposDTO> getEquiposDesdeAPI() throws JsonMappingException, JsonProcessingException {
        String url = "https://v3.football.api-sports.io/teams";
        String apiKey = "95af3cd5edfeb7119cd7d3442536e507";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("league", "39")
            .queryParam("season", "2022");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            entity,
            String.class);

        String jsonResponse = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);
        List<EquiposDTO> equipos = convertirObjetoApiToDTO(root);

        return equipos;
    }

    
    // Convertir la respuesta JSON en una lista de objetos EquiposDTO
    private List<EquiposDTO> convertirObjetoApiToDTO(Root root) {
        List<EquiposDTO> equipos = new ArrayList<>();

        for (Response response : root.response) {
            Team team = response.team;
            EquiposDTO equipo = new EquiposDTO(team.id, team.name, team.country, team.logo);
            equipos.add(equipo);
        }

        return equipos;
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
