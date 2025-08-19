package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;

public interface VueloRepository {
    Vuelo guardar(Vuelo viaje);
    Optional<Vuelo> buscarPorId(Long id);
}