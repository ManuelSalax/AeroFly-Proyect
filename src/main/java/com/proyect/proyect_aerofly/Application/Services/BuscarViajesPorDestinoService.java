package com.proyect.proyect_aerofly.Application.Services;

import java.util.List;

import com.proyect.proyect_aerofly.Application.UseCase.BuscarViajesPorDestinoUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

public class BuscarViajesPorDestinoService implements BuscarViajesPorDestinoUseCase {

    private final ViajeRepository viajeRepository;

    public BuscarViajesPorDestinoService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Vuelo> ejecutar(String destino) {
        return viajeRepository.buscarPorDestino(destino);
    }
}
