package com.proyect.proyect_aerofly.Domain.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;

public interface ViajeRepository {

    Vuelo guardar(Vuelo viaje);

    Optional<Vuelo> buscarPorId(Long id);

    List<Vuelo> buscarPorDestino(String destino);

    List<Vuelo> buscarPorFechas(LocalDate desde, LocalDate hasta);

    List<Vuelo> listarTodos();

    void eliminarPorId(Long id);
}