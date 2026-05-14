package com.kaislo.rooftop.repositories;

import com.kaislo.rooftop.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    // Este metodo es vital para el Login que haremos después
    Optional<Administrador> findByUsuarioAcceso(String usuarioAcceso);
}