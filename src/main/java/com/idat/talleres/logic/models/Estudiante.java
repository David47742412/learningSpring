package com.idat.talleres.logic.models;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Estudiante.findAll", query = "SELECT E FROM Estudiante E"),
        @NamedQuery(name = "Estudiante.findOne", query = "SELECT E FROM Estudiante E WHERE E.idEstudiante = :idEstudiante"),
})
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;

    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String apellidos;

    @Basic(optional = false)
    @Column(name = "Dni")
    private int Dni;

    @Basic(optional = false)
    @Column(name = "Codigo_est")
    private String Codigo_est;

    @Basic(optional = false)
    @Column(name = "idGrado")
    private int idGrado;

    public Estudiante() {

    }

    public Estudiante(String nombre, String apellidos, int dni, String codigo_est, int idGrado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.Dni = dni;
        this.Codigo_est = codigo_est;
        this.idGrado = idGrado;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int dni) {
        Dni = dni;
    }

    public String getCodigo_est() {
        return Codigo_est;
    }

    public void setCodigo_est(String codigo_est) {
        Codigo_est = codigo_est;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
}
