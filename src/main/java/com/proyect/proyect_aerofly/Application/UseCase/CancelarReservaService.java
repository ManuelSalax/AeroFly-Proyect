package com.proyect.proyect_aerofly.Application.UseCase;

import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;

public class CancelarReservaService implements CancelarReservaUseCase {

    private final ReservaRepository reservaRepository;

    public CancelarReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public void ejecutar(Long reservaId) {
        Reserva reserva = reservaRepository.buscarPorId(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
        reserva.cancelar();
        reservaRepository.guardar(reserva);
    }
}
