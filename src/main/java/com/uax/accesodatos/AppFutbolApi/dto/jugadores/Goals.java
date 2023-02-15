package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

public class Goals{
    public int total;
    public Object conceded;
    public Object assists;
    public Object saves;
    
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getConceded() {
		return conceded;
	}
	public void setConceded(Object conceded) {
		this.conceded = conceded;
	}
	public Object getAssists() {
		return assists;
	}
	public void setAssists(Object assists) {
		this.assists = assists;
	}
	public Object getSaves() {
		return saves;
	}
	public void setSaves(Object saves) {
		this.saves = saves;
	}
    
    
}
