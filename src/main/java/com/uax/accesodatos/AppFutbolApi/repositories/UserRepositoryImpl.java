package com.uax.accesodatos.AppFutbolApi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uax.accesodatos.AppFutbolApi.dto.usuario.UsuarioDTO;
import com.uax.accesodatos.AppFutbolApi.mapper.UsuarioRowMapper;

<<<<<<< HEAD

=======
>>>>>>> feature/cambiosLogin
@Repository
public class UserRepositoryImpl implements UserRepository {


	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public UsuarioDTO findByUsername(String username) {
		String sql = String.format(""
				+ "SELECT u.username, u.password, a.authority "
				+ "from users u, authorities a "
				+ "where u.username=a.username "
				+ "and u.username='%s'",username);
		
		return jdbctemplate.queryForObject(sql,new UsuarioRowMapper());
	}

}
