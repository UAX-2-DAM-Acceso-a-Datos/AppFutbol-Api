package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
    @GetMapping("/go-to-Favoritos")
    public String showListaJugadoresFavoritos(Model model) throws IOException {
    	
    	
        return "Favoritos/ListaFavoritos";
    }
	
}
