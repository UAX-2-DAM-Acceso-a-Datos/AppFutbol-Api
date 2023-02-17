package com.uax.accesodatos.AppFutbolApi.dto.equipos;


public class EquiposDTO {
	public int id;
    public String nombre;
    public String pais;
    public String urlfoto;
    public String estadio;
	
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

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}


	public EquiposDTO() {
		super();
	}

	public EquiposDTO(int id, String nombre, String pais, String urlfoto, String estadio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.urlfoto = urlfoto;
		this.estadio = estadio;
	}




}
