package com.kaislo.rooftop.controllers;

import com.kaislo.rooftop.models.ReservaParrilla;
import com.kaislo.rooftop.services.ReservaParrillaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaParrillaController {

    private final ReservaParrillaService reservaService;

    public ReservaParrillaController(ReservaParrillaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<ReservaParrilla> listarTodas() {
        return reservaService.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<?> reservar(@RequestBody ReservaParrilla reserva) {
        try {
            ReservaParrilla nuevaReserva = reservaService.crearReserva(reserva);
            return ResponseEntity.ok(nuevaReserva);
        } catch (RuntimeException e) {
            // Aquí capturamos el error de "Bloque ocupado" que definimos en el Service
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        try {
            ReservaParrilla reservaActualizada = reservaService.cambiarEstado(id, estado);
            return ResponseEntity.ok(reservaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}