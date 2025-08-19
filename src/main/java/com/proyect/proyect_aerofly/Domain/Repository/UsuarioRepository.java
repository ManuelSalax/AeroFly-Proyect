package com.proyect.proyect_aerofly.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.proyect.proyect_aerofly.Domain.Entities.Usuario;

public interface UsuarioRepository {

    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorUsername(String username);
    
    List<Usuario> listarTodos();
}
