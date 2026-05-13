package com.kaislo.rooftop.services;

import com.kaislo.rooftop.models.Residente;
import com.kaislo.rooftop.repositories.ResidenteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResidenteService {

    private final ResidenteRepository residenteRepository;

    // Inyección de dependencias: Le damos el "obrero" al "gerente"
    public ResidenteService(ResidenteRepository residenteRepository) {
        this.residenteRepository = residenteRepository;
    }

    public List<Residente> obtenerTodos() {
        return residenteRepository.findAll();
    }

    public Residente guardarResidente(Residente residente) {
        return residenteRepository.save(residente);
    }
}