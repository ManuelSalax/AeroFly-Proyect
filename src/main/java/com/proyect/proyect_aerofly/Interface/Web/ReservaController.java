package com.proyect.proyect_aerofly.Interface.Web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.CancelarReservaUseCase;
import com.proyect.proyect_aerofly.Application.UseCase.CrearReservaUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final CrearReservaUseCase crearReservaUseCase;
    private final CancelarReservaUseCase cancelarReservaUseCase;
    private final ReservaRepository reservaRepository;

    public ReservaController(
            CrearReservaUseCase crearReservaUseCase,
            CancelarReservaUseCase cancelarReservaUseCase,
            ReservaRepository reservaRepository) {
        this.crearReservaUseCase = crearReservaUseCase;
        this.cancelarReservaUseCase = cancelarReservaUseCase;
        this.reservaRepository = reservaRepository;
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

    // NUEVO ENDPOINT GET - LISTAR TODAS LAS RESERVAS
    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodasLasReservas() {
        try {
            List<Reserva> reservas = reservaRepository.listarTodos();
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
