package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.EquiposDTO;

public interface IEquiposRepository {
	List<EquiposDTO> findAll();
}
