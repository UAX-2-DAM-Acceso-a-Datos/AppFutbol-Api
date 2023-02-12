package com.uax.accesodatos.AppFutbolApi.DTO;

public class EquiposDTO {
	
	public int id;
    public String name;
    public String season;
    public String country;
    public String logo;
    public String urlimage;
    public String venue;
    
	public EquiposDTO(int id, String name, String season, String country, String logo, String urlimage, String venue) {
		super();
		this.id = id;
		this.name = name;
		this.season = season;
		this.country = country;
		this.logo = logo;
		this.urlimage = urlimage;
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
	public String getUrlimage() {
		return urlimage;
	}
	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

}
