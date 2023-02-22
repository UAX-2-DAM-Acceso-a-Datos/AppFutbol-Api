package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Controller
public class EquiposController {

    @Autowired
    private EquiposService equiposService;
    
    //Ir a equipos
    @GetMapping("/go-to-Equipos")
    public String showListaEquipos(Model model) {
    	return "Equipos/ListaEquipos";
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

    //Funcionalidad del boton de insertar en base de datos
    @GetMapping("add-equipos-favoritos")
    public String addEquipos(@RequestParam("idEquipo") int idEquipo, @RequestParam("nombreEquipo") String nombreEquipo,
                              @RequestParam("pais") String pais, @RequestParam("urlfoto") String urlfoto,
                              @RequestParam("estadio") String estadio) {
        EquiposDTO equipo = new EquiposDTO(idEquipo, nombreEquipo, pais, urlfoto);
        equiposService.addEquiposFavoritos(equipo);
        return "redirect:/go-to-favoritos";
    }
}
