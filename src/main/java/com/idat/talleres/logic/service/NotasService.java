package com.idat.talleres.logic.service;

import com.idat.talleres.logic.models.Notas;
import com.idat.talleres.logic.repository.NotasRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    public Notas update(Notas notas) {
        Notas actualNota = this.repository.findOne(notas.getIdNota());
        actualNota.setNota1(notas.getNota1());
        actualNota.setNota2(notas.getNota2());
        actualNota.setNota3(notas.getNota3());
        actualNota.setNota4(notas.getNota4());
        actualNota.setPromedio(notas.getPromedio());
        actualNota.setIdPeriodo(notas.getIdPeriodo());

        return this.repository.save(notas);

    }

    public void delete(Integer idNota) {
        this.repository.deleteById(idNota);
    }

}
