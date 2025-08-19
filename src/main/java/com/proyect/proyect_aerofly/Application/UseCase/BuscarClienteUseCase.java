package com.proyect.proyect_aerofly.Application.UseCase;

import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;

public interface BuscarClienteUseCase {
    Optional<Cliente> ejecutar(Long id);
}
