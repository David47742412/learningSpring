package com.idat.talleres.logic.controllers;

import com.idat.talleres.logic.models.Personal;
import com.idat.talleres.logic.service.PersonalService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalService service;

    public PersonalController(PersonalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{idPersonal}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> findOne(@PathVariable("idPersonal") int idPersonal) throws ResponseStatusException {
        Personal personal = this.service.findOne(idPersonal);
        if (personal != null) {
            return new ResponseEntity<>(personal, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personal not found");
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> insert(@RequestBody Personal personal) {
        this.service.insert(personal);
        return new ResponseEntity<>("Personal create successfully", HttpStatus.OK);
    }

    @PatchMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> update(@RequestBody Personal personal) {
        this.service.update(personal);
        return new ResponseEntity<>("Persona update successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idPersona}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object> delete(@PathVariable Integer idPersona) {
        this.service.delete(idPersona);
        return new ResponseEntity<>("Personal has been deleted", HttpStatus.OK);
    }
}
