package com.uax.accesodatos.AppFutbolApi.dto.estadios;

import java.util.ArrayList;

public class EstadiosResponseDTO {

	public ArrayList<EstadiosDTO> venues;

	public ArrayList<EstadiosDTO> getVenues() {
		return venues;
	}

	public void setVenues(ArrayList<EstadiosDTO> venues) {
		this.venues = venues;
	}
	
	
}
