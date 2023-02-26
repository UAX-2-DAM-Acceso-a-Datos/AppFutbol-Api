package com.uax.accesodatos.AppFutbolApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.services.EquiposService;

@Controller
public class TestController {

    @Autowired
    private EquiposService equiposService;

    @GetMapping("/test-api")
    public String testApi(Model model) {
        try {
            List<EquiposDTO> equipos = equiposService.getEquiposDesdeAPI();
            model.addAttribute("equipos", equipos);
            return "test-api";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
