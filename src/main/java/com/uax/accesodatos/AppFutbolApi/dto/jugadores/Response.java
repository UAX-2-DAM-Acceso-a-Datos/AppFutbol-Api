package com.uax.accesodatos.AppFutbolApi.dto.jugadores;

import java.util.ArrayList;

public class Response{
    public Player player;
    public ArrayList<Statistic> statistics;
    
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Statistic> getStatistics() {
		return statistics;
	}
	public void setStatistics(ArrayList<Statistic> statistics) {
		this.statistics = statistics;
	}
    
    
}
