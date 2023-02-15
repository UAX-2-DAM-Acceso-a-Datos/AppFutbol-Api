package com.uax.accesodatos.AppFutbolApi.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.Player;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.Response;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.Root;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Service
public class JugadoresService {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
	AppFutbolUtils utils;
    
    
    public List<JugadoresDTO> convertirObjetoApitoDTO(Root root) {
        ArrayList<JugadoresDTO> jugadores = new ArrayList<JugadoresDTO>();
        
        for (Response response : root.getResponse()) {
			Player jugador = response.getPlayer();
			JugadoresDTO parametros = new JugadoresDTO();
			parametros.setId(jugador.getId());
			parametros.setNombre(jugador.getName());
			parametros.setEdad(jugador.getAge());
			parametros.setNacionalidad(jugador.getNationality());
			parametros.setUrlfoto(jugador.getPhoto());
			
			jugadores.add(parametros);
		}
        
        return jugadores;
    }
    
    public ArrayList<JugadoresDTO> getJugadores() throws IOException {
        ArrayList<JugadoresDTO> jugadores = new ArrayList<>();
        
        String jsonResponse = utils.readFile("responsePlayers.json");

		Gson gson= new Gson();
		Root root=gson.fromJson(jsonResponse, Root.class);
        jugadores = (ArrayList<JugadoresDTO>) convertirObjetoApitoDTO(root);

        return jugadores;
    }

}
