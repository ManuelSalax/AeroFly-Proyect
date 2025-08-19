package com.proyect.proyect_aerofly.Application.Services;

import java.util.List;

import com.proyect.proyect_aerofly.Application.UseCase.RegistrarClienteUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;

public class RegistrarClienteService implements RegistrarClienteUseCase {

    private final ClienteRepository clienteRepository;

    public RegistrarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente ejecutar(Cliente cliente) {
        return clienteRepository.guardar(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }
}