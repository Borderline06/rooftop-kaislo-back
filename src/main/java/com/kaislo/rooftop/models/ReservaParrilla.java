package com.kaislo.rooftop.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity

@Table(name = "reservas_parrilla", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fecha_reserva", "hora_inicio", "hora_fin"})
})
public class ReservaParrilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    // Relación: Muchas reservas pueden pertenecer a Un Residente
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_residente", nullable = false)
    private Residente residente;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    // Solo permitiremos: "Confirmada", "Cancelada", "Finalizada"
    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    // Para la auditoría del panel de administración
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();



    public ReservaParrilla(){

    }

    public ReservaParrilla(String estado, LocalTime horaFin, LocalTime horaInicio, LocalDate fechaReserva, Residente residente) {
        this.estado = estado;
        this.horaFin = horaFin;
        this.horaInicio = horaInicio;
        this.fechaReserva = fechaReserva;
        this.residente = residente;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


}