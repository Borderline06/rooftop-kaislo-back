package com.kaislo.rooftop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "administradores")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column(name = "usuario_acceso", unique = true, nullable = false, length = 50)
    private String usuarioAcceso;

    // Se usa 255 de longitud porque los algoritmos como Bcrypt generan cadenas largas
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;

    // Constructor vacío (Obligatorio para JPA/Hibernate)
    public Administrador() {
    }

    // Constructor con parámetros (Sin el ID porque la BD lo genera automáticamente)
    public Administrador(String usuarioAcceso, String passwordHash, String rol) {
        this.usuarioAcceso = usuarioAcceso;
        this.passwordHash = passwordHash;
        this.rol = rol;
    }

    // --- Getters y Setters ---

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsuarioAcceso() {
        return usuarioAcceso;
    }

    public void setUsuarioAcceso(String usuarioAcceso) {
        this.usuarioAcceso = usuarioAcceso;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}