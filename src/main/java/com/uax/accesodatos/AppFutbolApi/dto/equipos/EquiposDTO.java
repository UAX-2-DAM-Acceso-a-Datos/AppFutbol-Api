package com.uax.accesodatos.AppFutbolApi.dto.equipos;

import java.util.List;

import com.uax.accesodatos.AppFutbolApi.dto.jugadores.JugadoresDTO;

public class EquiposDTO {
	public int id;
    public String nombre;
    public String pais;
    public String urlfoto;
	private List<EquiposDTO> data;
	
	public List<EquiposDTO> getData() {
		return data;
	}

	public void setData(List<EquiposDTO> data) {
		this.data = data;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getUrlfoto() {
		return urlfoto;
	}

	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}

	public EquiposDTO() {
		super();
	}

	public EquiposDTO(int id, String nombre, String pais, String urlfoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.urlfoto = urlfoto;
	}




}
