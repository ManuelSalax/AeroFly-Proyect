package com.proyect.proyect_aerofly.Domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {

    private Long id;
    private BigDecimal monto;
    private String metodoPago;
    private LocalDate fechaPago;
    private Reserva reserva;

    public Pago(Long id, Reserva reserva, BigDecimal monto, String metodoPago, LocalDate fechaPago) {
        this.id = id;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = fechaPago;
        this.reserva = reserva;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public Reserva getReserva() {
        return reserva;
    }

    // (Opcional) Setters si planeas permitir modificación
    // public void setMonto(BigDecimal monto) { this.monto = monto; }
    // public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    // public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }
    // public void setReserva(Reserva reserva) { this.reserva = reserva; }
}
