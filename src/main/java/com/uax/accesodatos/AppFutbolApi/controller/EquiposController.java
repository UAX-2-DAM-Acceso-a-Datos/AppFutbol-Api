package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Controller
public class EquiposController {



    @Autowired
    private EquiposService equiposService;

    @GetMapping("/go-to-Equipos")
    public String showListaEquipos(Model model) throws IOException {
    	
		
	    ArrayList<EquiposDTO> equipos = equiposService.getEquipos();
	    model.addAttribute("equipos", equipos);
    	
        return "Equipos/ListaEquipos";
    } 
    
    //Funcionalidad del boton de insertar en base de datos
    @GetMapping("add-equipos-favoritos")
    public String addEquipos(@RequestParam("idEquipo") int idEquipo, @RequestParam("nombreEquipo") String nombreEquipo,
                              @RequestParam("pais") String pais, @RequestParam("urlfoto") String urlfoto,
                              @RequestParam("estadio") String estadio) {
        EquiposDTO equipo = new EquiposDTO(idEquipo, nombreEquipo, pais, urlfoto);
        equiposService.addEquiposFavoritos(equipo);
        return "redirect:/go-to-favoritos";
    }

    //Insertar datos desde JSON
    @PostMapping("/insertar-equipos-desde-json")
    public String insertarEquiposDesdeJson(@RequestParam("jsonFile") MultipartFile jsonFile) {
        try {
            // Obtener el contenido del archivo JSON en forma de String
            String jsonContent = new String(jsonFile.getBytes());

            // Convertir el contenido del archivo JSON a una lista de objetos EquiposDTO utilizando Jackson
            ObjectMapper mapper = new ObjectMapper();
            List<EquiposDTO> equipos = mapper.readValue(jsonContent, new TypeReference<List<EquiposDTO>>(){});

            // Insertar la lista de objetos EquiposDTO en la base de datos utilizando el servicio EquiposService
            equiposService.getEquipos();
           
            return "redirect:/go-to-Equipos";
        } catch (IOException e) {
            e.printStackTrace();
            return "error-page";
        }
    }
    

}
