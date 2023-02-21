package com.uax.accesodatos.AppFutbolApi.dto.equipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;

public class EquiposResponseDTO {
    private String get;
    private int results;
    private Paging paging;
    private List<EquiposDTO> equipos;
    private Object errors;
	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		this.get = get;
	}
	public Object getErrors() {
		return errors;
	}
	public void setErrors(Object errors) {
		this.errors = errors;
	}
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public List<EquiposDTO> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<EquiposDTO> equipos) {
		this.equipos = equipos;
	}

	public List<Response> getResponse() {
		
	    List<Response> responses = new ArrayList<>();
	    if (equipos != null) {
	    for (EquiposDTO equipo : equipos) {
	        Response response = new Response();
	        Team team = new Team();
	        team.setId(equipo.getId());
	        team.setName(equipo.getNombre());
//	        team.setCode(equipo.getCode());
	        team.setCountry(equipo.getPais());
//	        team.setFounded(equipo.getFounded());
//	        team.setNational(equipo.isNational());
	        team.setLogo(equipo.getUrlfoto());
	        response.setTeam(team);
//	        Venue venue = new Venue();
//	        venue.setId(equipo.getVenue().getId());
//	        venue.setName(equipo.getVenue().getName());
//	        venue.setAddress(equipo.getVenue().getAddress());
//	        venue.setCity(equipo.getVenue().getCity());
//	        venue.setCapacity(equipo.getVenue().getCapacity());
//	        venue.setSurface(equipo.getVenue().getSurface());
//	        venue.setImage(equipo.getVenue().getImage());
//	        response.setVenue(venue);
//	        responses.add(response);
	    }
	   
	}
		return responses;

	}

}