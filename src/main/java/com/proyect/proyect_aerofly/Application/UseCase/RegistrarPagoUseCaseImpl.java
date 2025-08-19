package com.proyect.proyect_aerofly.Application.UseCase;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;

public class RegistrarPagoUseCaseImpl implements RegistrarPagoUseCase {

    private final ReservaRepository reservaRepository;
    private final PagoRepository pagoRepository;

    public RegistrarPagoUseCaseImpl(ReservaRepository reservaRepository, PagoRepository pagoRepository) {
        this.reservaRepository = reservaRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago registrarPago(Pago pago, Long reservaId) {
        Reserva reserva = reservaRepository.buscarPorId(reservaId).orElseThrow(() ->
                new IllegalArgumentException("Reserva no encontrada con ID: " + reservaId));
        return pagoRepository.guardar(pago, reserva);
    }
}