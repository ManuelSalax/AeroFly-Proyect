package com.proyect.proyect_aerofly.Domain.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;

public interface ViajeRepository {

    Viaje guardar(Viaje viaje);

    Optional<Viaje> buscarPorId(Long id);

    List<Viaje> buscarPorDestino(String destino);

    List<Viaje> buscarPorFechas(LocalDate desde, LocalDate hasta);

    List<Viaje> listarTodos();

    void eliminarPorId(Long id);
}