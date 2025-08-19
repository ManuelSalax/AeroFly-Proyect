package com.proyect.proyect_aerofly.Interface.Web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.ListarUsuariosUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarUsuarioUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;

    public UsuarioController(
        RegistrarUsuarioUseCase registrarUsuarioUseCase,
        ListarUsuariosUseCase listarUsuariosUseCase
    ) {
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.listarUsuariosUseCase = listarUsuariosUseCase;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = registrarUsuarioUseCase.ejecutar(usuario);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = listarUsuariosUseCase.ejecutar();
        return ResponseEntity.ok(usuarios);
    }
}
