package com.uax.accesodatos.AppFutbolApi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.uax.accesodatos.AppFutbolApi.dto.estadios.EstadiosDTO;
import com.uax.accesodatos.AppFutbolApi.dto.estadios.Response;
import com.uax.accesodatos.AppFutbolApi.dto.estadios.Root;
import com.uax.accesodatos.AppFutbolApi.repositories.EstadiosRepository;
import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;

@Service
public class EstadiosService {
	
	@Autowired
	AppFutbolUtils appFutbol;
	
	@Autowired 
	EstadiosRepository estadiosRepository;
	
	public ArrayList<EstadiosDTO> convertirObjetoApiToDTO(Root root) {
    	ArrayList<EstadiosDTO> estadios= new ArrayList<EstadiosDTO>();
    	
    	for (Response response : root.getResponse()) {

    		EstadiosDTO parametros= new EstadiosDTO();
			parametros.setAddress(response.getAddress());
			parametros.setCapacity(response.getCapacity());
			parametros.setCity(response.getCity());
			parametros.setCountry(response.getCountry());
			parametros.setId(response.getId());
			parametros.setImage(response.getImage());
			parametros.setName(response.getName());
			parametros.setSurface(response.getSurface());
			
			
			estadios.add(parametros);
		}
    	
    	
    	return estadios;
    }
	
	public ArrayList<EstadiosDTO> getEstadiosFromApi() throws IOException {
		
		RestTemplate restT = new RestTemplate();
		
		String result = appFutbol.readFile("responseVenues.json");
		
		Root estadios = getResponseByString(result);
		 
		ArrayList<EstadiosDTO> estadiosRooteado = convertirObjetoApiToDTO(estadios);
		
		return estadiosRooteado;
		
	}
	
public boolean addEstadiosFavoritos(EstadiosDTO estadio){
		
		estadiosRepository.saveEstadio(estadio);
		
		return true;
	}
	
	public boolean deleteEstadiosFavoritos(int id){
		
		estadiosRepository.deleteEstadio(id);
		
		return true;
	}
	
	public List<EstadiosDTO> getListaFavoritos() throws IOException{
		
		return estadiosRepository.getAllEstadios();
		
		
	}
	
	/*public EstadiosDTO getEstadiosById(int idEstadio) throws IOException {
		RestTemplate restT = new RestTemplate();
		
		String result = appFutbol.readFile("responseVenues.json");
		
		Root estadios = getResponseByString(result);
		
		return estadios;
		
	}*/
	
	public Root getResponseByString(String result) {
		
		Gson gson = new Gson();
		Root estadios = gson.fromJson(result, Root.class);
		return estadios;
	}
}
