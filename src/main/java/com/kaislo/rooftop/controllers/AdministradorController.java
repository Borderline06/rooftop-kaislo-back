package com.kaislo.rooftop.controllers;

import com.kaislo.rooftop.models.Administrador;
import com.kaislo.rooftop.services.AdministradorService;
import com.kaislo.rooftop.dtos.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdministradorController {

    private final AdministradorService adminService;

    public AdministradorController(AdministradorService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Administrador> listar() {
        return adminService.listarTodos();
    }

    @PostMapping("/registrar")
    public Administrador crear(@RequestBody Administrador admin) {
        return adminService.registrarAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Administrador admin = adminService.login(request.getUsuarioAcceso(), request.getPassword());
            // Si el login es correcto, devolvemos los datos del administrador (Código 200)
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            // Si falla la contraseña o el usuario, devolvemos un error 401 Unauthorized
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}