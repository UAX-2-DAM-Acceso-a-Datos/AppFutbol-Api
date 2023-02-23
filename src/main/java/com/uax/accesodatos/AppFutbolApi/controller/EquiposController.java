package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Controller
public class EquiposController {

    @Autowired
    private EquiposService equiposService;
    
    @Autowired
	AppFutbolUtils utils;
    
    //Ir a equipos
    @GetMapping("/go-to-Equipos")
    public String showListaEquipos(Model model) throws IOException {
    	  ArrayList<EquiposDTO> equipos = equiposService.getEquipos();
  	    model.addAttribute("equipos", equipos);
  	    
    	return "Equipos/ListaEquipos";
    }
    
    //Buscar equipos usando json
    @GetMapping("/search-equipo")
    public String mostrarEquipo(Model model, @RequestParam("nombre") String nombre) throws IOException {
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


    //Método temporal para convertirObjetoApiToDTO
    private List<EquiposDTO> convertirObjetoApiToDTO(Root root) {
        List<EquiposDTO> equipos = new ArrayList<>();
        for (Response response : root.getResponse()) {
            Team team = response.getTeam();
            EquiposDTO equipo = new EquiposDTO();
            equipo.setId(team.getId());
            equipo.setNombre(team.getName());
            equipo.setPais(team.getCountry());
            equipo.setUrlfoto(team.getLogo());
            equipos.add(equipo);
        }
        return equipos;
    }


	//Funcionalidad del boton de insertar en base de datos con JSON
    @GetMapping("add-equipos-favoritos")
    public String addEquipos(@RequestParam("id") int id, @RequestParam("nombre") String nombre,
                              @RequestParam("pais") String pais, @RequestParam("urlfoto") String urlfoto) {
        EquiposDTO equipo = new EquiposDTO(id, nombre, pais, urlfoto);
        equiposService.addEquiposFavoritos(equipo);
        
        return "redirect:/go-to-Favoritos";
    }
    
    @PostMapping("/add-equipos-favoritos")
    public String addEquipoFavorito(@RequestParam("id") int id, 
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("pais") String pais,
                                    @RequestParam("urlfoto") String urlfoto) {
        // Tu código para insertar el equipo en la base de datos

        return "redirect:/go-to-Favoritos";
    }

    
//    //Buscador con API por pais
//    @GetMapping("/equipos")
//    public ModelAndView equipos(@RequestParam(name = "query", required = false) String query) throws IOException {
//        ModelAndView modelAndView = new ModelAndView("Equipos/ListaEquipos");
//        List<EquiposDTO> equipos;
//        if (query != null && !query.isEmpty()) {
//            EquiposResponseDTO equiposResponseDTO = equiposService.getEquiposFromApi();
//            List<Response> response = equiposResponseDTO.getResponse();
//            equipos = new ArrayList<>();
//            for (Response equipo : response) {
//                EquiposDTO equiposDTO = new EquiposDTO();
//                equiposDTO.setNombre(equipo.getTeam().getName());
//                equiposDTO.setPais(equipo.getTeam().getCountry());
//                equiposDTO.setUrlfoto(equipo.getTeam().getLogo());
//                equipos.add(equiposDTO);
//            }
//            equipos = equipos.stream().filter(equipo -> equipo.getPais().equalsIgnoreCase(query)).collect(Collectors.toList());
//        } else {
//            equipos = equiposService.findAll();
//        }
//        modelAndView.addObject("equipos", equipos);
//        return modelAndView;
//    }


}
