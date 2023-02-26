package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.EntrenadoresDTO;

public interface IEntrenadoresRepository {
	public List<EntrenadoresDTO> findAll();
}
