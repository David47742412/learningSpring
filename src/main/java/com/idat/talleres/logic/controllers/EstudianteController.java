package com.idat.talleres.logic.controllers;

import com.idat.talleres.logic.models.Estudiante;
import com.idat.talleres.logic.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Estudiante> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{idEstudiante}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> findOne(@PathVariable Integer idEstudiante) {
        return new ResponseEntity<>(this.service.findOne(idEstudiante), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Estudiante estudiante) {
        this.service.insert(estudiante);
        return new ResponseEntity<>("", )
    }

}
