package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

import java.util.List;

public class JugadoresDTO {
	
	public int id;
	public String nombre;
	public int edad;
	public String nacionalidad;
	public String urlfoto;
	public int equipo;
	private List<JugadoresDTO> data;
	
	public JugadoresDTO(int id, String nombre, int edad, String nacionalidad, String urlfoto, int equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.urlfoto = urlfoto;
		this.equipo = equipo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}


	public List<JugadoresDTO> getData() {
		return data;
	}


	public void setData(List<JugadoresDTO> data) {
		this.data = data;
	}
	
	

}
