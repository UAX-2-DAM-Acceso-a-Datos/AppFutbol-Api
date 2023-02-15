package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

import java.util.ArrayList;

public class Root{
    public String get;
    public Parameters parameters;
    public ArrayList<Object> errors;
    public int results;
    public Paging paging;
    public ArrayList<Response> response;
    
	public String getGet() {
		return get;
	}
	public void setGet(String get) {
		this.get = get;
	}
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public ArrayList<Object> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<Object> errors) {
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
	public ArrayList<Response> getResponse() {
		return response;
	}
	public void setResponse(ArrayList<Response> response) {
		this.response = response;
	}
    
    
}
