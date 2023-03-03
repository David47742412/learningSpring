package com.idat.talleres.logic.controllers;

import com.idat.talleres.logic.models.Notas;
import com.idat.talleres.logic.service.NotasService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    private final NotasService service;

    public NotasController(NotasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idNota}")
    public ResponseEntity<Object> findOne(@PathVariable Integer idNota) {
        return new ResponseEntity<>(this.service.findOne(idNota), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Notas nota) {
        this.service.insert(nota);
        return new ResponseEntity<>("Nota create successfully", HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Object> update(@RequestBody Notas nota) {
        this.service.update(nota);
        return new ResponseEntity<>("Nota update successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{idNota}")
    public ResponseEntity<Object> delete(@PathVariable Integer idNota) {
         this.service.delete(idNota);
         return new ResponseEntity<>("Nota has been deleted", HttpStatus.OK);
    }

}
