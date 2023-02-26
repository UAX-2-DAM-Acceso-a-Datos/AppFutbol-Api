	package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;
import com.uax.accesodatos.AppFutbolApi.services.EstadiosService;
import com.uax.accesodatos.AppFutbolApi.services.JugadoresService;

@Controller
public class FavoritosController {
	
    @Autowired
    private JugadoresService jugadoresService;
    
    @Autowired
    private EquiposService equiposService;
    
    @Autowired
    private EstadiosService estadiosService;
	
    @GetMapping("/go-to-Favoritos")
    public String showListaJugadoresFavoritos(Model model) throws IOException {
    	
    	List<JugadoresDTO> jugadores = jugadoresService.getListaFavoritos();
    	model.addAttribute("jugadoresfav",jugadores);
    	
    	ArrayList<EquiposDTO> equipos = (ArrayList<EquiposDTO>) equiposService.findAll();
    	model.addAttribute("equiposfav",equipos);
    	
    	List<EstadiosDTO> estadios = estadiosService.getListaFavoritos();
    	model.addAttribute("estadiosfav",estadios);
    	
    	
        return "Favoritos/ListaFavoritos";
    }
    
	@GetMapping("/delete-jugador")
	public String deleteProductoById(@RequestParam("idJugador") int idJugador) {
		
		jugadoresService.deleteJugadoresFavoritos(idJugador);

		return "redirect:/go-to-Favoritos";
	}
	
	//Borrar Equipo
	@GetMapping("/delete-equipo")
	public String deleteEquipoById(@RequestParam("id") int id) {
		
		equiposService.deleteEquiposFavoritos(id);

		return "redirect:/go-to-Favoritos";
	}
	
	

	@GetMapping("/delete-estadio")
	public String deleteEstadioById(@RequestParam("idEstadio") int idEstadio) {
		
		estadiosService.deleteEstadiosFavoritos(idEstadio);
	
		return "redirect:/go-to-Favoritos";
	}

    	
}
