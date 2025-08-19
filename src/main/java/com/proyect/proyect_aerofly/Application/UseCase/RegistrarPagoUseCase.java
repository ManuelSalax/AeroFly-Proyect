package com.proyect.proyect_aerofly.Application.UseCase;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;

public interface RegistrarPagoUseCase {
    Pago registrarPago(Pago pago, Long reservaId);
}
