package com.proyect.proyect_aerofly.Domain.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Itinerario {

    private LocalDate fecha;
    private LocalTime hora;
    private String actividad;

    public Itinerario(LocalDate fecha, LocalTime hora, String actividad) {
        this.fecha = fecha;
        this.hora = hora;
        this.actividad = actividad;
    }

    // Getters
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getActividad() { return actividad; }
}
