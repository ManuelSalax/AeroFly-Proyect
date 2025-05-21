package com.proyect.proyect_aerofly.Domain.Entities;

import java.time.LocalDate;

public class Reserva {

    private Long id;
    private Cliente cliente;
    private Viaje viaje;
    private LocalDate fechaReserva; 
    private EstadoReserva estado;

    public Reserva(Long id, Cliente cliente, Viaje viaje, LocalDate fechaReserva) {
        this.id = id;
        this.cliente = cliente;
        this.viaje = viaje;
        this.fechaReserva = fechaReserva;
        this.estado = EstadoReserva.CONFIRMADA;
    }

    // Getters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Viaje getViaje() { return viaje; }
    public LocalDate getFechaReserva() { return fechaReserva; }
    public EstadoReserva getEstado() { return estado; }

    // Lógica de negocio
    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
    }
}
