package com.uax.accesodatos.AppFutbolApi.dto.equipos;

public class Response{
		
	public Team team;
    public Venue venue;
    
    public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

}
