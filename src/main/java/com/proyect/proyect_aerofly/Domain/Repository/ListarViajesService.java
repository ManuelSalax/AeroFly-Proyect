package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;

public class ListarViajesService implements ListarViajesUseCase {

    private final ViajeRepository viajeRepository;

    public ListarViajesService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> ejecutar() {
        return viajeRepository.listarTodos();
    }
}
