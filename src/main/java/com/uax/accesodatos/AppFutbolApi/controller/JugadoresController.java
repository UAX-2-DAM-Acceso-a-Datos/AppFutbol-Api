package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.services.JugadoresService;

@Controller
public class JugadoresController {
	
    @Autowired
    private JugadoresService jugadoresService;

    @GetMapping("/go-to-Jugadores")
    public String showListaJugadores(Model model) throws IOException {
    	
	    ArrayList<JugadoresDTO> jugadores = jugadoresService.getJugadores();
	    model.addAttribute("jugadores", jugadores);
    	
        return "Jugadores/ListaJugadores";
    }
    
    @GetMapping("/add-jugadores-favoritos")
    public String addJugadores(@RequestParam("idJugador") int idJugador, @RequestParam("nombreJugador") String nombreJugador, @RequestParam("edadJugador") int edadJugador, 
    @RequestParam("nacJugador") String nacJugador, @RequestParam("fotoJugador") String fotoJugador,  @RequestParam("equipo") int equipo) throws IOException {
    	
    	JugadoresDTO jugador = new JugadoresDTO(idJugador, nombreJugador, edadJugador,nacJugador,fotoJugador,equipo);
    	
    	jugadoresService.addJugadoresFavoritos(jugador);
    	
        return "redirect:/go-to-Favoritos";
    }
	
	
}
