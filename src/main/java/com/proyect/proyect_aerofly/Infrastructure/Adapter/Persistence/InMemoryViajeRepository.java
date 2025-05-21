package com.proyect.proyect_aerofly.Infrastructure.Adapter.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

@Repository
public class InMemoryViajeRepository implements ViajeRepository {

    private final Map<Long, Viaje> almacenamiento = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Viaje guardar(Viaje viaje) {
        if (viaje.getId() == null) {
            viaje = new Viaje(currentId++, viaje.getDestino(), viaje.getFechaInicio(), viaje.getFechaFin(), viaje.getPrecio(), viaje.getDescripcion());
        }
        almacenamiento.put(viaje.getId(), viaje);
        return viaje;
    }

    @Override
    public Optional<Viaje> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Viaje> buscarPorDestino(String destino) {
        return almacenamiento.values().stream()
                .filter(v -> v.getDestino().toLowerCase().contains(destino.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Viaje> buscarPorFechas(LocalDate desde, LocalDate hasta) {
        return almacenamiento.values().stream()
                .filter(v -> (v.getFechaInicio().isAfter(desde) || v.getFechaInicio().isEqual(desde)) &&
                             (v.getFechaFin().isBefore(hasta) || v.getFechaFin().isEqual(hasta)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Viaje> listarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }
}
