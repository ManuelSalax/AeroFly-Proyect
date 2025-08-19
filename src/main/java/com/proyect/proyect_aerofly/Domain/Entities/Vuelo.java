package com.proyect.proyect_aerofly.Domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Vuelo {

    private Long id;
    private String destino;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private BigDecimal precio;
    private String descripcion;
    private List<Itinerario> itinerario;
    private String origen;
    
    public Vuelo(Long id, String destino, LocalDate fechaInicio, LocalDate fechaFin, BigDecimal precio, String descripcion, String origen) {
        this.id = id;
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.descripcion = descripcion;
        this.origen = origen;
    }
    // Getters
    public Long getId() { return id; }
    public String getDestino() { return destino; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public BigDecimal getPrecio() { return precio; }
    public String getDescripcion() { return descripcion; }
    public List<Itinerario> getItinerario() { return itinerario; }
    public String getOrigen() { return origen; }

    // Setters
    public void setDestino(String destino) { this.destino = destino; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setItinerario(List<Itinerario> itinerario) { this.itinerario = itinerario; }
    public void setOrigen(String origen) { this.origen = origen; }
}
