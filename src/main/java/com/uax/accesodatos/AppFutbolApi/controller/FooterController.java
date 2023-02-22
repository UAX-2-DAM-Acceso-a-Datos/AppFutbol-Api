package com.uax.accesodatos.AppFutbolApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {
	//Componente footer
    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }
}
