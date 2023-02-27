package com.uax.accesodatos.AppFutbolApi.rest;

import com.uax.accesodatos.AppFutbolApi.dto.equipos.EquiposDTO;
import com.uax.accesodatos.AppFutbolApi.repositories.IEquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public EquiposDTO findById(@PathVariable int id) {
        EquiposDTO equipo = equiposRepository.findById(id);
        if (equipo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipo not found");
        }
        return equipo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquiposDTO saveEquipo(@RequestBody EquiposDTO equipo) {
        boolean result = equiposRepository.saveEquipo(equipo);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save equipo");
        }
        return equipo;
    }

    @PutMapping("/{id}")
    public EquiposDTO updateEquipo(@PathVariable int id, @RequestBody EquiposDTO equipo) {
        equipo.setId(id);
        boolean result = equiposRepository.updateEquipo(equipo);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update equipo");
        }
        return equipo;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEquipo(@PathVariable int id) {
        boolean result = equiposRepository.deleteEquipo(id);
        if (!result) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipo not found");
        }
    }
}

