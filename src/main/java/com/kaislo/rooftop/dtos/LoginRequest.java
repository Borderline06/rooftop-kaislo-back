package com.kaislo.rooftop.dtos;

public class LoginRequest {
    private String usuarioAcceso;
    private String password;

    // Getters y Setters
    public String getUsuarioAcceso() {
        return usuarioAcceso;
    }

    public void setUsuarioAcceso(String usuarioAcceso) {
        this.usuarioAcceso = usuarioAcceso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}