package com.idat.talleres.logic.service;

import com.idat.talleres.logic.models.Estudiante;
import com.idat.talleres.logic.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class EstudianteService {

    private final EstudianteRepository repository;


    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> findAll() {
        return this.repository.findAll();
    }

    public Estudiante findOne(Integer idEstudiante) {
        return this.repository.findOne(idEstudiante);
    }

    public Estudiante insert(Estudiante estudiante) {
        return this.repository.save(estudiante);
    }

    public Estudiante update(Estudiante estudiante) throws ResponseStatusException {
        try {
            Estudiante isValidEstudiante = this.repository.findOne(estudiante.getIdEstudiante());
            return this.repository.save(estudiante);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this student's not found");
        }
    }

    public void delete(Integer idEstudiante) throws ResponseStatusException {
        try {
            this.repository.deleteById(idEstudiante);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this student's not found");
        }
    }

}
