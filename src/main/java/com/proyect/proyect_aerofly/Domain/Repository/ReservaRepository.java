package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Reserva;

public interface ReservaRepository {

    Reserva guardar(Reserva reserva);

    Optional<Reserva> buscarPorId(Long id);

    List<Reserva> listarPorCliente(Long clienteId);

    List<Reserva> listarTodos();

    void eliminarPorId(Long id);
}