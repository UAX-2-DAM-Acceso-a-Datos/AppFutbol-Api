package com.uax.accesodatos.AppFutbolApi.Repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.DTO.EquiposDTO;

public interface IEquiposRepository {
	List<EquiposDTO> findAll();
}
