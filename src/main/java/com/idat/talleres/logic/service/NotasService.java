package com.idat.talleres.logic.service;

import com.idat.talleres.logic.models.Notas;
import com.idat.talleres.logic.repository.NotasRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class NotasService {

    private final NotasRepository repository;

    public NotasService(NotasRepository repository) {
        this.repository = repository;
    }

    public List<Notas> findAll() {
        return this.repository.findAll();
    }

    public Notas findOne(Integer idNota) {
        return this.repository.findOne(idNota);
    }

    public Notas insert(Notas notas) {
        return this.repository.save(notas);
    }

    public Notas update(Notas notas) throws ResponseStatusException {
        try {
            Notas isValidNota = this.repository.findOne(notas.getIdNota());
            return this.repository.save(notas);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notas's not found");
        }

    }

    public void delete(Integer idNota) throws ResponseStatusException {
        try {
            Notas isValidNota = this.repository.findOne(idNota);
            this.repository.deleteById(idNota);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notas's not found");
        }
    }

}
