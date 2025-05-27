package com.proyect.proyect_aerofly.Interface.Web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Repository.RegistrarPagoUseCase;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final RegistrarPagoUseCase registrarPagoUseCase;

    public PagoController(RegistrarPagoUseCase registrarPagoUseCase) {
        this.registrarPagoUseCase = registrarPagoUseCase;
    }

    @PostMapping
    public ResponseEntity<Pago> registrarPago(@RequestParam Long reservaId, @RequestBody Pago pago) {
        try {
            Pago resultado = registrarPagoUseCase.ejecutar(reservaId, pago);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

