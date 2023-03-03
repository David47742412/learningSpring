package com.idat.talleres.logic.service;

import com.idat.talleres.logic.models.Personal;
import com.idat.talleres.logic.repository.PersonalRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PersonalService {

    private final PersonalRepository repository;

    public PersonalService(PersonalRepository repository) {
        this.repository = repository;
    }

    public List<Personal> findAll() {
        return this.repository.findAll();
    }

    public Personal findOne(Integer idPersonal) {
        return this.repository.findOne(idPersonal);
    }

    public void insert(Personal personal) {
        this.repository.save(personal);
    }

    public void update(Personal personal) throws ResponseStatusException {
        try {
            Personal isValidPersonal = this.repository.findOne(personal.getIdPersonal());
            this.repository.save(personal);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this Personal is not found");
        }

    }

    public void delete(Integer idPersona) throws ResponseStatusException {
        try {
            Personal isValidPersonal = this.repository.findOne(idPersona);
            System.out.println(isValidPersonal.getIdPersonal() != null);
            this.repository.deleteById(idPersona);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personal not found");
        }
    }

}
