package com.kaislo.rooftop.repositories;

import com.kaislo.rooftop.models.ReservaParrilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaParrillaRepository extends JpaRepository<ReservaParrilla, Long> {
}