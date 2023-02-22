package com.uax.accesodatos.AppFutbolApi.repositories;

import com.uax.accesodatos.AppFutbolApi.dto.usuario.UsuarioDTO;

public interface UserRepository {
   
    public UsuarioDTO findByUsername(String username);
     
}