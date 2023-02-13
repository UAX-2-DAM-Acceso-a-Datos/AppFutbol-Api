package com.uax.accesodatos.AppFutbolApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.AppFutbolApi.dto.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;

@Controller
public class EquiposController {
	
	@Autowired
	private EquiposService equiposService;

	@GetMapping("/equipos")
	public String mostrarEquipos(@RequestParam(name = "busqueda", required = false) String busqueda, Model model) {
	    List<EquiposDTO> equipos;
	    if (busqueda != null) {
	        equipos = equiposService.buscarEquipos(busqueda);
	    } else {
	        equipos = equiposService.findAll();
	    }
	    model.addAttribute("equipos", equipos);
	    return "listaEquipos";
	}

}
