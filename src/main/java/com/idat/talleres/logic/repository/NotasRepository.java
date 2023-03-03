package com.idat.talleres.logic.repository;

import com.idat.talleres.logic.models.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {

    @Query(name = "Notas.findAll")
    List<Notas> findAll();

    @Query(name = "Notas.findOne")
    Notas findOne(Integer idNota);

}
