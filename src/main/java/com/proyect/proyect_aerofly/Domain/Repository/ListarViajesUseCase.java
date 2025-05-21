package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;

public interface ListarViajesUseCase {
    List<Viaje> ejecutar();
}