package com.uax.accesodatos.AppFutbolApi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.dto.EntrenadoresDTO;
import com.uax.accesodatos.AppFutbolApi.dto.entrenadores.Response;
import com.uax.accesodatos.AppFutbolApi.dto.entrenadores.Root;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;


@Service
public class EntrenadoresService {
	@Autowired
	AppFutbolUtils utils;
	
	 public List<EntrenadoresDTO>convertirObjetoApiToDTO(Root root) {
	    	ArrayList<EntrenadoresDTO> equipos= new ArrayList<EntrenadoresDTO>();
	    	
	    	for (Response response : root.getResponse()) {
	   
				EntrenadoresDTO parametros= new EntrenadoresDTO();
				parametros.setId(response.getId());
				parametros.setName(response.getName());
				parametros.setAge(String.valueOf(response.getAge()));
				parametros.setCountry(response.getNationality());
				parametros.setUrlimage(response.getPhoto());
				parametros.setIdTeam(response.getTeam().getId());
				
				
				equipos.add(parametros);
			}
	    	
	    	
	    	return equipos;
	    }
	   
	    public ArrayList<EntrenadoresDTO> getEntrenadores() throws IOException {
	        ArrayList<EntrenadoresDTO> entrenadores = new ArrayList<>();
	        
	        String jsonResponse = utils.readFile("coachs.json");

			Gson gson= new Gson();
			Root root=gson.fromJson(jsonResponse, Root.class);
	        entrenadores = (ArrayList<EntrenadoresDTO>) convertirObjetoApiToDTO(root);

	        return entrenadores;
	    }
}
