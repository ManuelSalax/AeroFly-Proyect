package com.proyect.proyect_aerofly.Interface.Web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.BuscarClienteUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarClienteUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final RegistrarClienteUseCase registrarClienteUseCase;
    private final BuscarClienteUseCase buscarClienteUseCase;

    public ClienteController(
        RegistrarClienteUseCase registrarClienteUseCase,
        BuscarClienteUseCase buscarClienteUseCase
    ) {
        this.registrarClienteUseCase = registrarClienteUseCase;
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(registrarClienteUseCase.ejecutar(cliente));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return buscarClienteUseCase.ejecutar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
    return ResponseEntity.ok(registrarClienteUseCase.listarTodos());
}
}
