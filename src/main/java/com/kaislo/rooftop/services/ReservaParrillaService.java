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
        // REGLA DE NEGOCIO: Máximo 1 reserva activa por residente
        Long idDelVecino = nuevaReserva.getResidente().getIdResidente();
        if (reservaRepository.existsByResidente_IdResidenteAndEstado(idDelVecino, "Confirmada")) {
            throw new RuntimeException("Este residente ya tiene un turno reservado. Debe esperar a que finalice para reservar otro.");
        }

        nuevaReserva.setEstado("Confirmada");
        try {
            return reservaRepository.save(nuevaReserva);
        } catch (Exception e) {
            throw new RuntimeException("El bloque horario seleccionado ya se encuentra ocupado.");
        }
    }

    public ReservaParrilla cambiarEstado(Long idReserva, String nuevoEstado) {
        // 1. Buscamos la reserva, si no existe lanzamos un error
        ReservaParrilla reserva = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("La reserva con ID " + idReserva + " no existe."));

        // 2. Actualizamos el estado ("Cancelada", "Finalizada", etc.)
        reserva.setEstado(nuevoEstado);

        // 3. Guardamos los cambios en PostgreSQL
        return reservaRepository.save(reserva);
    }
}