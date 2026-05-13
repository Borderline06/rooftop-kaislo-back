package com.kaislo.rooftop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "residentes")
public class Residente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResidente;

    @Column(name = "num_departamento", unique = true, nullable = false, length = 10)


    private String numDepartamento;

    @Column(name = "nombre_contacto", nullable = false, length = 100)
    private String nombreContacto;

    @Column(name = "telefono_contacto", nullable = false, length = 20)
    private String telefonoContacto;

    // Constructor vacío (Obligatorio para JPA/Hibernate)
    public Residente() {
    }

    public Residente(Long idResidente, String numDepartamento, String nombreContacto, String telefonoContacto) {
        this.idResidente = idResidente;
        this.numDepartamento = numDepartamento;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
    }


    public Long getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(Long idResidente) {
        this.idResidente = idResidente;
    }

    public String getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(String numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
}