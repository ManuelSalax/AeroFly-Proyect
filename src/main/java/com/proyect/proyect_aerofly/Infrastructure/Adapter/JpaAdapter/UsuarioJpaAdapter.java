package com.proyect.proyect_aerofly.Infrastructure.Adapter.JpaAdapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.proyect.proyect_aerofly.Domain.Entities.Usuario;
import com.proyect.proyect_aerofly.Domain.Entities.UsuarioEntity;
import com.proyect.proyect_aerofly.Domain.Repository.UsuarioRepository;
import com.proyect.proyect_aerofly.Infrastructure.jpa.JpaUsuarioRepository;
@Primary
@Component
@Qualifier("usuarioJpaAdapter")
public class UsuarioJpaAdapter implements UsuarioRepository {

    private final JpaUsuarioRepository usuarioRepositoryJpa;

    public UsuarioJpaAdapter(JpaUsuarioRepository usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setUsername(usuario.getUsername());
        entity.setPassword(usuario.getPassword());
        entity.setRol(usuario.getRol());
        UsuarioEntity guardado = usuarioRepositoryJpa.save(entity);
        return new Usuario(guardado.getId(), guardado.getUsername(), guardado.getPassword(), guardado.getRol());
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepositoryJpa.findByUsername(username)
            .map(u -> new Usuario(u.getId(), u.getUsername(), u.getPassword(), u.getRol()));
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

        @Override
    public List<Usuario> listarTodos() {
        return usuarioRepositoryJpa.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
        private Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(entity.getId(), entity.getUsername(),entity.getPassword(), entity.getRol());
    }

}