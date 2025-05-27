package com.proyect.proyect_aerofly.Infrastructure.Adapter.JpaAdapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Entities.ClienteEntity;
import com.proyect.proyect_aerofly.Domain.Repository.ClienteRepository;
import com.proyect.proyect_aerofly.Infrastructure.jpa.JpaClienteRepository;
@Primary
@Repository
public class ClienteJpaAdapter implements ClienteRepository {

    private final JpaClienteRepository jpaRepository;

    public ClienteJpaAdapter(JpaClienteRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        ClienteEntity entity = toEntity(cliente);
        ClienteEntity guardado = jpaRepository.save(entity);
        return toDomain(guardado);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Cliente> listarTodos() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return guardar(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        jpaRepository.deleteById(id);
    }

    // Conversores

    private ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion()
        );
    }

    private Cliente toDomain(ClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }
}