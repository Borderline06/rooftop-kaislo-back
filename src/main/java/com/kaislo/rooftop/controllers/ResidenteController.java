package com.kaislo.rooftop.controllers;

import com.kaislo.rooftop.models.Residente;
import com.kaislo.rooftop.services.ResidenteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residentes") // Esta es la URL de tu API
@CrossOrigin(origins = "http://localhost:5173")
public class ResidenteController {

    private final ResidenteService residenteService;

    public ResidenteController(ResidenteService residenteService) {
        this.residenteService = residenteService;
    }

    // Si entras desde el navegador a la URL, se ejecuta esto (Muestra los datos)
    @GetMapping
    public List<Residente> listar() {
        return residenteService.obtenerTodos();
    }

    // Aquí recibirá los datos enviados desde el Front-End para guardarlos
    @PostMapping
    public Residente crear(@RequestBody Residente residente) {
        return residenteService.guardarResidente(residente);
    }
}