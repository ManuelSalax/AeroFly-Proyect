package com.proyect.proyect_aerofly.Application.Services;

import java.time.LocalDate;
import java.util.Optional;

import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

public class CrearReservaService implements CrearReservaUseCase {

    private final ClienteRepository clienteRepository;
    private final ViajeRepository viajeRepository;
    private final ReservaRepository reservaRepository;

    public CrearReservaService(ClienteRepository clienteRepository, ViajeRepository viajeRepository, ReservaRepository reservaRepository) {
        this.clienteRepository = clienteRepository;
        this.viajeRepository = viajeRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva ejecutar(Long clienteId, Long viajeId) {
        Optional<Cliente> clienteOpt = clienteRepository.buscarPorId(clienteId);
        Optional<Vuelo> viajeOpt = viajeRepository.buscarPorId(viajeId);

        if (clienteOpt.isEmpty() || viajeOpt.isEmpty()) {
            throw new IllegalArgumentException("Cliente o viaje no encontrado");
        }

        Reserva reserva = new Reserva(null, clienteOpt.get(), viajeOpt.get(), LocalDate.now());
        return reservaRepository.guardar(reserva);
    }
}