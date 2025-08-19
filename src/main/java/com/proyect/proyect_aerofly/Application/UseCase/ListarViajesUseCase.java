package com.proyect.proyect_aerofly.Application.UseCase;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;

public interface ListarViajesUseCase {
    List<Vuelo> ejecutar();
}