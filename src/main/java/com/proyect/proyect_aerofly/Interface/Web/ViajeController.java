package com.proyect.proyect_aerofly.Interface.Web;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyect_aerofly.Application.UseCase.ListarViajesUseCase;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    private final ListarViajesUseCase listarViajesUseCase;
    private final ViajeRepository viajeRepository;

    public ViajeController(ListarViajesUseCase listarViajesUseCase, ViajeRepository viajeRepository) {
        this.listarViajesUseCase = listarViajesUseCase;
        this.viajeRepository = viajeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> listar() {
        return ResponseEntity.ok(listarViajesUseCase.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@RequestBody Vuelo viaje) {
        Vuelo nuevoViaje = viajeRepository.guardar(viaje);
        return ResponseEntity.ok(nuevoViaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> buscarPorId(@PathVariable Long id) {
        return viajeRepository.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}