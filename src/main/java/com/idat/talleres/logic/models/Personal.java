package com.idat.talleres.logic.models;

import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Personal.findAll", query = "SELECT P FROM Personal P"),
        @NamedQuery(name = "Personal.findOne", query = "SELECT P FROM Personal P WHERE P.idPersonal = :idPersonal")
})
public class Personal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonal")
    private Integer idPersonal;

    @Basic(optional = false)
    @Column(name = "Nombre")
    private String Nombre;

    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;

    @Basic(optional = false)
    @Column(name = "Usuario")
    private String usuario;

    @Basic(optional = false)
    @Column(name = "Clave")
    private String clave;

    public Personal() {

    }

    public Personal(String nombre, String apellidos, String Usuario, String Clave) {
        this.Nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = Usuario;
        this.clave = Clave;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
