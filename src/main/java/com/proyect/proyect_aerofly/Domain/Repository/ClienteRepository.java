package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;

public interface ClienteRepository {

    Cliente guardar(Cliente cliente);

    Optional<Cliente> buscarPorId(Long id);

    List<Cliente> listarTodos();

    Cliente actualizar(Cliente cliente);

    void eliminarPorId(Long id);
}
