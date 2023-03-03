package com.idat.talleres.logic.repository;

import com.idat.talleres.logic.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query(name = "Estudiante.findAll")
    List<Estudiante> findAll();

    @Query(name = "Estudiante.findOne")
    Estudiante findOne(Integer idEstudiante);

}
