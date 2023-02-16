package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class FavoritosController {
	
    @GetMapping("/go-to-Favoritos")
    public String showListaJugadores(Model model) throws IOException {
    	
    	
        return "Favoritos/ListaFavoritos";
    }
	

}
