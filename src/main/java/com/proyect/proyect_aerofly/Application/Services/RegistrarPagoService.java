package com.proyect.proyect_aerofly.Application.Services;

import java.time.LocalDate;

import com.proyect.proyect_aerofly.Application.UseCase.RegistrarPagoUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;


public class RegistrarPagoService implements RegistrarPagoUseCase {

    private final ReservaRepository reservaRepository;
    private final PagoRepository pagoRepository;

    public RegistrarPagoService(ReservaRepository reservaRepository, PagoRepository pagoRepository) {
        this.reservaRepository = reservaRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Pago registrarPago(Pago pago, Long reservaId) {
        Reserva reserva = reservaRepository.buscarPorId(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));

        pago = new Pago(null, reserva, pago.getMonto(), pago.getMetodoPago(), LocalDate.now());
        return pagoRepository.guardar(pago, reserva);
    }
}
