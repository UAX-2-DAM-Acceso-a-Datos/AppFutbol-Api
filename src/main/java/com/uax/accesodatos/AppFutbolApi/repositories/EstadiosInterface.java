package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;

public interface EstadiosInterface {

	public List<EstadiosDTO> getAllEstadios();
	public boolean saveEstadio(EstadiosDTO estadio);
	public boolean deleteEstadio(int id);
}
