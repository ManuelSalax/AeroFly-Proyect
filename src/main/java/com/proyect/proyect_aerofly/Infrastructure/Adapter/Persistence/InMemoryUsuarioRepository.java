package com.proyect.proyect_aerofly.Infrastructure.Adapter.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Usuario;
import com.proyect.proyect_aerofly.Domain.Repository.UsuarioRepository;

@Repository
public class InMemoryUsuarioRepository implements UsuarioRepository {

    private final Map<Long, Usuario> almacenamiento = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario = new Usuario(currentId++, usuario.getUsername(), usuario.getPassword(), usuario.getRol());
        }
        almacenamiento.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return almacenamiento.values().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
}
