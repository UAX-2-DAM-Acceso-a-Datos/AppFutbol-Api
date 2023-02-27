package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;
import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;

public interface IEquiposRepository {
	List<EquiposDTO> findAll();
	public boolean saveEquipo(EquiposDTO equipo);
	boolean deleteEquipo(int idEquipo);
	EquiposDTO findById(int id);
	boolean updateEquipo(EquiposDTO equipo);
	
}
