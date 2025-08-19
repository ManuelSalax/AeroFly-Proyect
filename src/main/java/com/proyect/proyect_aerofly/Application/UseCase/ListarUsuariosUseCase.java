package com.proyect.proyect_aerofly.Application.UseCase;

import java.util.List;

import com.proyect.proyect_aerofly.Domain.Entities.Usuario;

public interface ListarUsuariosUseCase {
    List<Usuario> ejecutar();
}