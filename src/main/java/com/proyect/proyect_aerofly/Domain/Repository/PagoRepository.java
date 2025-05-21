package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;

public interface PagoRepository {

    Pago guardar(Pago pago);

    Optional<Pago> buscarPorId(Long id);

    List<Pago> listarPorReserva(Long reservaId);

    List<Pago> listarTodos();

    void eliminarPorId(Long id);
}
