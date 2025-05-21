package com.proyect.proyect_aerofly.Domain.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;

public class RegistrarClienteService implements RegistrarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public RegistrarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente ejecutar(Cliente cliente) {
        return clienteRepository.guardar(cliente);
    }
}