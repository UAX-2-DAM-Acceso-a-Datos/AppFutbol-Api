package com.uax.accesodatos.AppFutbolApi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyErrorController implements ErrorController{
	
	@GetMapping("/error")
	public String showPageError404(Exception e, HttpServletResponse req){
		
		String vista ="";
		
		switch(req.getStatus()) {
		case HttpServletResponse.SC_NOT_FOUND:{
			
			vista = "404error";
		}
		case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:{
			
			vista = "500error";
			return vista;
		}
		
		default:
			vista = "404";
	}
		
		return vista;
	}

	@ExceptionHandler(Exception.class)
	public String showPageErrorGeneric(Exception e){
		
		return "ExceptionPage";
	}

}