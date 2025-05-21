package com.proyect.proyect_aerofly.Interface.Web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.CancelarReservaUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaUseCase;

@RestController
@RequestMapping("/api/reservas")  // base URL para este recurso
public class ReservaController {

    private final CrearReservaUseCase crearReservaUseCase;
    private final CancelarReservaUseCase cancelarReservaUseCase;

    public ReservaController(CrearReservaUseCase crearReservaUseCase, CancelarReservaUseCase cancelarReservaUseCase) {
        this.crearReservaUseCase = crearReservaUseCase;
        this.cancelarReservaUseCase = cancelarReservaUseCase;
    }

    // POST /api/reservas
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestParam Long clienteId, @RequestParam Long viajeId) {
        try {
            var reserva = crearReservaUseCase.ejecutar(clienteId, viajeId);
            return ResponseEntity.ok(reserva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT /api/reservas/{id}/cancelar
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelarReserva(@PathVariable Long id) {
        try {
            cancelarReservaUseCase.ejecutar(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
