package com.proyect.proyect_aerofly.Application.Services;

import com.proyect.proyect_aerofly.Application.UseCase.RegistrarUsuarioUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Usuario;
import com.proyect.proyect_aerofly.Domain.Repository.UsuarioRepository;

public class RegistrarUsuarioService implements RegistrarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public RegistrarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario ejecutar(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }
}
