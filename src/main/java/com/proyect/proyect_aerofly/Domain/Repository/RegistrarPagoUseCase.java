package com.proyect.proyect_aerofly.Domain.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;

public interface RegistrarPagoUseCase {
    Pago ejecutar(Long reservaId, Pago pago);
}
