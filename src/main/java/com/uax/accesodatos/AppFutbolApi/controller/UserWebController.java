package com.uax.accesodatos.AppFutbolApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uax.accesodatos.AppFutbolApi.dto.usuario.UsuarioDTO;
import com.uax.accesodatos.AppFutbolApi.services.UserService;

@Controller
public class UserWebController {

	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String irPantallaRegistro(Model model) {
		
		return "Security/registration";
	}
	
	@PostMapping("/register")
	public String registrarUsuarioWeb(@ModelAttribute("usuario") UsuarioDTO usuario) {
		
		usuario.setRoles("USER");
		userService.registerUserDB(usuario);
		
		return "login";
	}
}
