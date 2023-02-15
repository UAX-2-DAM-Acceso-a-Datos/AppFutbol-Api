package com.uax.accesodatos.AppFutbolApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
	@RequestMapping("*/error")
	public String showError404Generic(Exception ex) {
		
		return "404error";
	}
}
