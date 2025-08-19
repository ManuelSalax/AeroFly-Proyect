package com.proyect.proyect_aerofly.Application.Services;

import java.util.List;

import com.proyect.proyect_aerofly.Application.UseCase.ListarPagosUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;

public class ListarPagosService implements ListarPagosUseCase {

    private final PagoRepository pagoRepository;

    public ListarPagosService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> ejecutar() {
        return pagoRepository.listarTodos();
    }
}