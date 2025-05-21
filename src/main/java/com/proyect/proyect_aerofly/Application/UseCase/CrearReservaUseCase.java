package com.proyect.proyect_aerofly.Application.UseCase;

import com.proyect.proyect_aerofly.Domain.Entities.Reserva;

public interface CrearReservaUseCase {
    Reserva ejecutar(Long clienteId, Long viajeId);
}