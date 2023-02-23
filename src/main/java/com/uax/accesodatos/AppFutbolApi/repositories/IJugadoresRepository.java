package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;

public interface IJugadoresRepository {
	
	public boolean saveJugador(JugadoresDTO jugador);
	public boolean deleteJugador(int id);
	public List<JugadoresDTO> getAllJugadores();

}
