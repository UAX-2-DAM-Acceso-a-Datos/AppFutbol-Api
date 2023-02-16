package com.uax.accesodatos.AppFutbolApi.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;
import com.uax.accesodatos.AppFutbolApi.mapper.JugadoresRowMapper;

public class JugadoresRepository implements IJugadoresRepository{
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public boolean saveJugador(JugadoresDTO jugadores) {
		try {
			
			String sql = String.format("INSERT INTO jugadores (id,nombre,edad,nacionalidad, urlfoto, equipo) VALUES('%d','%s','%d','%s','%s','%s')", jugadores.getId(), jugadores.getNombre(), jugadores.getEdad(), jugadores.getNacionalidad(), jugadores.getUrlfoto(), jugadores.getEquipo());
			jdbctemplate.execute(sql);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean deleteJugador(int id) {
		try {
			
			String sql = String.format("DELETE FROM jugadores WHERE id='%d'",id);
			jdbctemplate.execute(sql);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<JugadoresDTO> getAllJugadores() {
		
		return jdbctemplate.query("SELECT jugadores.id, jugadores.nombre, jugadores.edad, jugadores.nacionalidad, jugadores.urlfoto, jugadores.equipo FROM jugadores", new JugadoresRowMapper());

	}

}
