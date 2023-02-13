package com.uax.accesodatos.AppFutbolApi.dto.equipos;

public class EquiposDTO {
	
	public int id;
    public String name;
    public String season;
    public String country;
    public String logo;
    public String venue;
    
	public EquiposDTO(int id, String name, String season, String country, String logo, String urlimage, String venue) {
		super();
		this.id = id;
		this.name = name;
		this.season = season;
		this.country = country;
		this.logo = logo;
		this.venue = venue;
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
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

}
