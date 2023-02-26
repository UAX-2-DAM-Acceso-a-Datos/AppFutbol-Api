package com.uax.accesodatos.AppFutbolApi.rest;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.repositories.IEquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquiposRest {

    @Autowired
    private IEquiposRepository equiposRepository;

    @GetMapping
    public List<EquiposDTO> findAll() {
        return equiposRepository.findAll();
    }

    @PostMapping
    public boolean saveEquipo(@RequestBody EquiposDTO equipo) {
        return equiposRepository.saveEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEquipo(@PathVariable int id) {
        return equiposRepository.deleteEquipo(id);
    }
}
