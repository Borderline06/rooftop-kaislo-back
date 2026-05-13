package com.kaislo.rooftop.services;

import com.kaislo.rooftop.models.ReservaParrilla;
import com.kaislo.rooftop.repositories.ReservaParrillaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaParrillaService {

    private final ReservaParrillaRepository reservaRepository;

    public ReservaParrillaService(ReservaParrillaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaParrilla> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public ReservaParrilla crearReserva(ReservaParrilla nuevaReserva) {
        nuevaReserva.setEstado("Confirmada");
        try {
            return reservaRepository.save(nuevaReserva);
        } catch (Exception e) {
            throw new RuntimeException("El bloque horario seleccionado ya se encuentra ocupado.");
        }
    }
}