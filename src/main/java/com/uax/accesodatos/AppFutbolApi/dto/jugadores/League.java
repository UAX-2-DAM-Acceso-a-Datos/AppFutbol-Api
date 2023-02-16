package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

public class League{
    public int id;
    public String name;
    public String country;
    public String logo;
    public Object flag;
    public Object season;
    
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Object getFlag() {
		return flag;
	}
	public void setFlag(Object flag) {
		this.flag = flag;
	}
	public Object getSeason() {
		return season;
	}
	public void setSeason(Object season) {
		this.season = season;
	}
    
    
}
