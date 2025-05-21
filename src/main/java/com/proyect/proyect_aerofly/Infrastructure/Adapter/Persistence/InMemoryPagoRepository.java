package com.proyect.proyect_aerofly.Infrastructure.Adapter.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;

@Repository
public class InMemoryPagoRepository implements PagoRepository {

    private final Map<Long, Pago> almacenamiento = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Pago guardar(Pago pago) {
        if (pago.getId() == null) {
            pago = new Pago(currentId++, pago.getReserva(), pago.getMonto(), pago.getMetodoPago(), pago.getFechaPago());
        }
        almacenamiento.put(pago.getId(), pago);
        return pago;
    }

    @Override
    public Optional<Pago> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Pago> listarPorReserva(Long reservaId) {
        return almacenamiento.values().stream()
                .filter(p -> p.getReserva().getId().equals(reservaId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pago> listarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }
}