package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.config.AppFutbolApiProperties;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Controller
public class EquiposController {

    @Autowired
    private EquiposService equiposService;
    
    @Autowired
	AppFutbolUtils utils;
    
    @Autowired
    private AppFutbolApiProperties apiProperties;

    
    //Ir a equipos y almacena equipos en una array y los pasa con model JSON LOCAL
    @GetMapping("/go-to-equipos-json")
    public String showListaEquiposJSON(Model model) throws IOException {
    	  ArrayList<EquiposDTO> equipos = equiposService.getEquiposJSON();
  	    model.addAttribute("equipos", equipos);
  	    
    	return "Equipos/ListaEquipos";
    }
    //Ir a equipos y almacena equipos en una array y los pasa con model API ONLINE
    @GetMapping("/go-to-equipos-api")
    public String showListaEquiposAPI(Model model) throws IOException {
        List<EquiposDTO> equipos = equiposService.getEquiposDesdeAPI();
        model.addAttribute("equipos", equipos);

        return "Equipos/ListaEquipos";
    }

    //Buscar equipos usando JSON LOCAL
    @GetMapping("/search-equipo-json")
    public String mostrarEquipoJSON(Model model, @RequestParam("nombre") String nombre) throws IOException {
        String jsonResponse = AppFutbolUtils.readFile("responseTeams.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(jsonResponse, Root.class);

        List<EquiposDTO> equipos = convertirObjetoApiToDTO(root);

        if (nombre != null && !nombre.isEmpty()) {
            equipos = equipos.stream()
                    .filter(equipo -> equipo.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("equipos", equipos);

        return "Equipos/ListaEquipos";
    }
    
  //BUSCADOR equipo por nombre usando API ONLINE
    @GetMapping("/search-equipo-api")
    public String mostrarEquipoAPI(Model model, @RequestParam("nombre") String nombre) {
        String url = "https://v3.football.api-sports.io/teams";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiProperties.getKey()); // AplicationProperties KEY
        headers.set("x-rapidapi-host", "v3.football.api-sports.io");
        String nombreModificado = nombre.replaceAll(" ", "+");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("search", nombreModificado);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        String jsonResponse = response.getBody();
        System.out.println(jsonResponse); // Imprime la respuesta JSON en la consola
        ObjectMapper objectMapper = new ObjectMapper();
        Root root = null;
        try {
            root = objectMapper.readValue(jsonResponse, Root.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<EquiposDTO> equipos = convertirObjetoApiToDTO(root);
        model.addAttribute("equipos", equipos);
        return "Equipos/ListaEquipos";
    }



    //Método temporal para convertirObjetoApiToDTO
    //para convertir los datos de "Root" 
    //en una lista de objetos "EquiposDTO"

    private List<EquiposDTO> convertirObjetoApiToDTO(Root root) {
        List<EquiposDTO> equipos = new ArrayList<>();
        if (root != null) {
            for (Response response : root.getResponse()) {
                Team team = response.getTeam();
                EquiposDTO equipo = new EquiposDTO();
                equipo.setId(team.getId());
                equipo.setNombre(team.getName());
                equipo.setPais(team.getCountry());
                equipo.setUrlfoto(team.getLogo());
                equipos.add(equipo);
            }
        }
        return equipos;
    }


	//Funcionalidad del boton de insertar en base de datos con JSON LOCAL
    @GetMapping("add-equipos-favoritos-json")

    public String addEquipos(@RequestParam("id") int id, @RequestParam("nombre") String nombre,
                              @RequestParam("pais") String pais, @RequestParam("urlfoto") String urlfoto) {
        EquiposDTO equipo = new EquiposDTO(id, nombre, pais, urlfoto);
        equiposService.addEquiposFavoritos(equipo);
        
        return "redirect:/go-to-Favoritos";
    }


  //Funcionalidad del boton de insertar en base de datos con JSON LOCAL
    @PostMapping("/add-equipos-favoritos-json")
    public String addEquipoFavoritoJSON(@RequestParam("id") int id, 
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("pais") String pais,
                                    @RequestParam("urlfoto") String urlfoto) {


        return "redirect:/go-to-Favoritos";
    }
    
    //Insertar equipos favoritos en base de datos desde la API ONLINE
    @GetMapping("/add-equipos-favoritos-api")
    public String addEquipoFavoritoAPI(@RequestParam("id") int id, 
                                        @RequestParam("nombre") String nombre,
                                        @RequestParam("pais") String pais,
                                        @RequestParam("urlfoto") String urlfoto) throws JsonMappingException, JsonProcessingException {
        // Get the list of teams from the API
        List<EquiposDTO> equipos = equiposService.getEquiposDesdeAPI();
        
        // Find the team with the matching ID
        EquiposDTO equipo = equipos.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        // If the team was found, add it to the database
        if (equipo != null) {
            equiposService.addEquiposFavoritos(equipo);
        }

        return "redirect:/go-to-Favoritos";
    }



}
