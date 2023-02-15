package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
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
}


//Service logica, controller me llama getEquipos, metodo que se llame getequipos en service, objeeto de tipo arraylist, 
//getEquipos()
//model.add(ArrayList);

//@GetMapping("/go-to-Equipos")
//public String mostrarEquipos(@RequestParam(name = "busqueda", required = false) String busqueda, Model model) {
//    List<EquiposDTO> equipos;
//    if (busqueda != null) {
//        equipos = equiposService.buscarEquipos(busqueda);
//    } else {
//        equipos = equiposService.findAll();
//    }
//    model.addAttribute("equipos", equipos);
//    
//    return "Equipos/ListaEquipos";
//}
