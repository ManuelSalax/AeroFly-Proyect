package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;

public class BuscarViajesPorDestinoService implements BuscarViajesPorDestinoUseCase {

    private final ViajeRepository viajeRepository;

    public BuscarViajesPorDestinoService(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    @Override
    public List<Viaje> ejecutar(String destino) {
        return viajeRepository.buscarPorDestino(destino);
    }
}
