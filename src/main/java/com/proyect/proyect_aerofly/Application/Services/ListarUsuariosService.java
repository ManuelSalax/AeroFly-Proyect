package com.proyect.proyect_aerofly.Application.Services;

import java.util.List;

import com.proyect.proyect_aerofly.Application.UseCase.ListarUsuariosUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Usuario;
import com.proyect.proyect_aerofly.Domain.Repository.UsuarioRepository;

public class ListarUsuariosService implements ListarUsuariosUseCase {

    private final UsuarioRepository usuarioRepository;

    public ListarUsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> ejecutar() {
        return usuarioRepository.listarTodos();
    }
}
