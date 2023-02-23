package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;
import com.uax.accesodatos.AppFutbolApi.services.EstadiosService;

@Controller
public class EstadiosController {

	@Autowired 
	EstadiosService estadiosService;
	
	@GetMapping("/go-to-Estadios")
	public String goToEstadios(Model modelo) throws IOException {
		ArrayList<EstadiosDTO> estadios = estadiosService.getEstadiosFromApi();
		modelo.addAttribute("estadios", estadios);
		return "Estadios/ListaEstadios";
		
	}
	
	@GetMapping("/add-estadios-favoritos")
	public String addEstadiosFavoritos(@RequestParam("idEstadio") int idEstadio, @RequestParam("nombreEstadio") String nombreEstadio, @RequestParam("fotoEstadio") String fotoEstadio){

    	EstadiosDTO estadio = new EstadiosDTO(idEstadio, nombreEstadio, fotoEstadio);
    	estadiosService.addEstadiosFavoritos(estadio);
    	
        return "redirect:/go-to-Favoritos";
	}
		
}
