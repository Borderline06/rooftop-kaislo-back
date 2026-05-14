package com.kaislo.rooftop.services;

import com.kaislo.rooftop.models.Administrador;
import com.kaislo.rooftop.repositories.AdministradorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorService {

    private final AdministradorRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdministradorService(AdministradorRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Administrador> listarTodos() {
        return adminRepository.findAll();
    }

    public Administrador registrarAdmin(Administrador admin) {
        // Encriptamos la contraseña antes de guardarla en la base de datos
        String passwordHashed = passwordEncoder.encode(admin.getPasswordHash());
        admin.setPasswordHash(passwordHashed);
        return adminRepository.save(admin);
    }

    public Administrador login(String usuarioAcceso, String passwordPlana) {
        // 1. Buscamos al usuario en la BD
        Administrador admin = adminRepository.findByUsuarioAcceso(usuarioAcceso)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Comparamos la contraseña plana con el hash usando BCrypt
        if (passwordEncoder.matches(passwordPlana, admin.getPasswordHash())) {
            return admin; // Login exitoso
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }
}