package com.proyect.proyect_aerofly.Interface.Web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyect.proyect_aerofly.Domain.Entities.Viaje;
import com.proyect.proyect_aerofly.Domain.Repository.BuscarViajesPorDestinoUseCase;
import com.proyect.proyect_aerofly.Domain.Repository.ListarViajesUseCase;

@RequestMapping("/api/viajes")
public class ViajeController {
    private final ListarViajesUseCase listarViajesUseCase;
    private final BuscarViajesPorDestinoUseCase buscarViajesPorDestinoUseCase;

    public ViajeController(ListarViajesUseCase listar, BuscarViajesPorDestinoUseCase buscar) {
        this.listarViajesUseCase = listar;
        this.buscarViajesPorDestinoUseCase = buscar;
    }

    @GetMapping
    public ResponseEntity<List<Viaje>> listarTodos() {
        return ResponseEntity.ok(listarViajesUseCase.ejecutar());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Viaje>> buscarPorDestino(@RequestParam String destino) {
        return ResponseEntity.ok(buscarViajesPorDestinoUseCase.ejecutar(destino));
    }
}