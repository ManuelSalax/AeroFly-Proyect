package com.proyect.proyect_aerofly.Domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {

    private Long id;
    private Reserva reserva;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDate fechaPago;

    public Pago(Long id, Reserva reserva, BigDecimal monto, String metodoPago, LocalDate fechaPago) {
        this.id = id;
        this.reserva = reserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
    }

    // Getters
    public Long getId() { return id; }
    public Reserva getReserva() { return reserva; }
    public BigDecimal getMonto() { return monto; }
    public String getMetodoPago() { return metodoPago; }
    public LocalDate getFechaPago() { return fechaPago; }
}
