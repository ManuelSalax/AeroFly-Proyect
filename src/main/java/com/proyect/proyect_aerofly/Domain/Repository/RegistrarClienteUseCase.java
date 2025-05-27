package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;

public interface RegistrarClienteUseCase {
    Cliente ejecutar(Cliente cliente);
    List<Cliente> listarTodos();
}
