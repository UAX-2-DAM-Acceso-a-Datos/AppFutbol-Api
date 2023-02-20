package com.uax.accesodatos.AppFutbolApi.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.uax.accesodatos.AppFutbolApi.dto.EntrenadoresDTO;
import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.services.EntrenadoresService;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.services.JugadoresService;




@Controller
public class EntrenadoresController {
	
	@Autowired
    private EntrenadoresService entrenadoresService;

    @GetMapping("/go-to-Entrenadores")
    public String showListaEntrenadores(Model model) throws IOException {
    	
		
	    ArrayList<EntrenadoresDTO> entrenadores = entrenadoresService.getEntrenadores();
	    model.addAttribute("entrenadores", entrenadores);
    	
        return "Entrenadores/ListaEntrenadores";
    } 

}