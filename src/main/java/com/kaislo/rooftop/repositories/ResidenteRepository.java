package com.kaislo.rooftop.repositories;

import com.kaislo.rooftop.models.Residente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenteRepository extends JpaRepository<Residente, Long> {

}