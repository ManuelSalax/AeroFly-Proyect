package com.proyect.proyect_aerofly.Application.Services;

import java.util.Optional;

import com.proyect.proyect_aerofly.Application.UseCase.BuscarClienteUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;

public class BuscarClienteService implements BuscarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public BuscarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> ejecutar(Long id) {
        return clienteRepository.buscarPorId(id);
    }
}
