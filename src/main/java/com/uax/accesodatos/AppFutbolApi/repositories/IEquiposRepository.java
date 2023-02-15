package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.*;

public interface IEquiposRepository {
	List<EquiposDTO> findAll();
}
