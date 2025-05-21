package com.proyect.proyect_aerofly.Interface.Web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarClienteUseCase;

@RequestMapping("/api/clientes")
public class ClienteController {
    private final RegistrarClienteUseCase registrarClienteUseCase;

    public ClienteController(RegistrarClienteUseCase registrarClienteUseCase) {
        this.registrarClienteUseCase = registrarClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(registrarClienteUseCase.ejecutar(cliente));
    }
}
