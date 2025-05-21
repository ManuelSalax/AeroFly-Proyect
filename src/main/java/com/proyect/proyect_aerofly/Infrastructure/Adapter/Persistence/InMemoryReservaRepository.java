package com.proyect.proyect_aerofly.Infrastructure.Adapter.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;

@Repository
public class InMemoryReservaRepository implements ReservaRepository {

    private final Map<Long, Reserva> almacenamiento = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Reserva guardar(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva = new Reserva(currentId++, reserva.getCliente(), reserva.getViaje(), reserva.getFechaReserva());
        }
        almacenamiento.put(reserva.getId(), reserva);
        return reserva;
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Reserva> listarPorCliente(Long clienteId) {
        return almacenamiento.values().stream()
                .filter(r -> r.getCliente().getId().equals(clienteId))
                .toList();
    }

    @Override
    public List<Reserva> listarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }
}
