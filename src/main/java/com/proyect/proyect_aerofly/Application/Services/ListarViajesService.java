package com.proyect.proyect_aerofly.Application.Services;

import java.util.List;

import com.proyect.proyect_aerofly.Application.UseCase.ListarViajesUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

public class ListarViajesService implements ListarViajesUseCase {

    private final ViajeRepository viajeRepository;

    public ListarViajesService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Vuelo> ejecutar() {
        return viajeRepository.listarTodos();
    }
}
