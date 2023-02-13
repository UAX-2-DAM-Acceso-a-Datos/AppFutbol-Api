package com.uax.accesodatos.AppFutbolApi.dto;

public class EntrenadoresDTO {
	
	public int id;
    public String name;
    public String surname;
    public String age;
    public String country;
    public String urlimage;
    public int idTeam;
    
    
	public EntrenadoresDTO(int id, String name, String surname, String age, String country, String urlimage,
			int idTeam) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country = country;
		this.urlimage = urlimage;
		this.idTeam = idTeam;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUrlimage() {
		return urlimage;
	}
	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

    
    
}
