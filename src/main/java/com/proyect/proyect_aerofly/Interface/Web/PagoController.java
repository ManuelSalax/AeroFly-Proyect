package com.proyect.proyect_aerofly.Interface.Web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.ListarPagosUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.RegistrarPagoUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Pago;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final RegistrarPagoUseCase registrarPagoUseCase;
    private final ListarPagosUseCase listarPagosUseCase;

    public PagoController(RegistrarPagoUseCase registrarPagoUseCase, ListarPagosUseCase listarPagosUseCase) {
        this.registrarPagoUseCase = registrarPagoUseCase;
        this.listarPagosUseCase = listarPagosUseCase;
    }

    @PostMapping
    public ResponseEntity<Pago> registrarPago(@RequestParam Long reservaId, @RequestBody Pago pago) {
        try {
            Pago resultado = registrarPagoUseCase.registrarPago(pago, reservaId);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        return ResponseEntity.ok(listarPagosUseCase.ejecutar());
    }
}

