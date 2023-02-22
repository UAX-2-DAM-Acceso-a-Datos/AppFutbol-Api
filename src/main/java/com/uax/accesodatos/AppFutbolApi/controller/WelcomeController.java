package com.uax.accesodatos.AppFutbolApi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uax.accesodatos.AppFutbolApi.utils.AppFutbolUtils;


@Controller
public class WelcomeController {

	@Autowired
	AppFutbolUtils util;
	
	// Login form
	@RequestMapping("/login")
	public String login(Model model) {

		return "login.html";
	}
	
    @GetMapping("/")
    public String home() throws IOException {
    	
    	String response = util.readFile("responsePlayers.json");
    	String responseEquipos = util.readFile("responseTeams.json");
        return "index";
    }
    
	@RequestMapping("*/error")
	public String showError404Generic(Exception ex) {
		
		return "404error";
	}
}
