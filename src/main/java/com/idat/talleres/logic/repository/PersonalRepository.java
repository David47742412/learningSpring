package com.idat.talleres.logic.repository;

import com.idat.talleres.logic.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    @Query(name = "Personal.findAll")
    List<Personal> findAll();

    @Query(name = "Personal.findOne")
    Personal findOne(Integer idPersonal);

}
