package com.idat.talleres.logic.models;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Notas.findAll", query = "SELECT N FROM Notas N"),
        @NamedQuery(name = "Notas.findOne", query = "SELECT N FROM Notas N WHERE N.idNota = :idNota")
})
public class Notas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNota")
    private Integer idNota;

    @Basic(optional = false)
    @Column(name = "Nota1")
    private float nota1;

    @Basic(optional = false)
    @Column(name = "Nota2")
    private float nota2;

    @Basic(optional = false)
    @Column(name = "Nota3")
    private float nota3;

    @Basic(optional = false)
    @Column(name = "Nota4")
    private float nota4;

    @Basic(optional = false)
    @Column(name = "Promedio")
    private float promedio;

    @Basic(optional = false)
    @Column(name = "idPeriodo")
    private int idPeriodo;

    public Notas() {

    }

    public Notas(float nota1, float nota2, float nota3, float nota4, float promedio, int idPeriodo) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.promedio = promedio;
        this.idPeriodo = idPeriodo;
    }


    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
