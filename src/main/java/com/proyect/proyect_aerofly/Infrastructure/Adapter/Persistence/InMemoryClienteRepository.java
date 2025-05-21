package com.proyect.proyect_aerofly.Infrastructure.Adapter.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;

@Repository
public class InMemoryClienteRepository implements ClienteRepository {

    private final Map<Long, Cliente> almacenamiento = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Cliente guardar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente = new Cliente(currentId++, cliente.getNombre(), cliente.getEmail(), cliente.getTelefono(), cliente.getDireccion());
        }
        almacenamiento.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(almacenamiento.values());
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        almacenamiento.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public void eliminarPorId(Long id) {
        almacenamiento.remove(id);
    }
}
