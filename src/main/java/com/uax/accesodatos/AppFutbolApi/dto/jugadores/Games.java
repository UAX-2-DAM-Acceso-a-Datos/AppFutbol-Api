package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

public class Games{
    public int appearences;
    public int lineups;
    public int minutes;
    public Object number;
    public String position;
    public Object rating;
    public boolean captain;
    
	public int getAppearences() {
		return appearences;
	}
	public void setAppearences(int appearences) {
		this.appearences = appearences;
	}
	public int getLineups() {
		return lineups;
	}
	public void setLineups(int lineups) {
		this.lineups = lineups;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public Object getNumber() {
		return number;
	}
	public void setNumber(Object number) {
		this.number = number;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Object getRating() {
		return rating;
	}
	public void setRating(Object rating) {
		this.rating = rating;
	}
	public boolean isCaptain() {
		return captain;
	}
	public void setCaptain(boolean captain) {
		this.captain = captain;
	}
    
    
}
