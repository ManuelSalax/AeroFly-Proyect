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
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final CrearReservaUseCase crearReservaUseCase;
    private final CancelarReservaUseCase cancelarReservaUseCase;

    public ReservaController(CrearReservaUseCase crearReservaUseCase, CancelarReservaUseCase cancelarReservaUseCase) {
        this.crearReservaUseCase = crearReservaUseCase;
        this.cancelarReservaUseCase = cancelarReservaUseCase;
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestParam Long clienteId, @RequestParam Long viajeId) {
        try {
            Reserva reserva = crearReservaUseCase.ejecutar(clienteId, viajeId);
            return ResponseEntity.ok(reserva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        try {
            cancelarReservaUseCase.ejecutar(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}