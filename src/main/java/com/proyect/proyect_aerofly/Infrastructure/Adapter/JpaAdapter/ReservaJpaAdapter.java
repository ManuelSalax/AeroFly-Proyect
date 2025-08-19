package com.proyect.proyect_aerofly.Infrastructure.Adapter.JpaAdapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Entities.ClienteEntity;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Entities.ReservaEntity;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Entities.VueloEntity;
import com.proyect.proyect_aerofly.Domain.Repository.ReservaRepository;
import com.proyect.proyect_aerofly.Infrastructure.jpa.JpaReservaRepository;
@Primary
@Repository
public class ReservaJpaAdapter implements ReservaRepository {

    private final JpaReservaRepository jpaReservaRepository;

    public ReservaJpaAdapter(JpaReservaRepository jpaReservaRepository) {
        this.jpaReservaRepository = jpaReservaRepository;
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        ReservaEntity entity = toEntity(reserva);
        ReservaEntity saved = jpaReservaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return jpaReservaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Reserva> listarPorCliente(Long clienteId) {
        return jpaReservaRepository.findByClienteId(clienteId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarTodos() {
        return jpaReservaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        jpaReservaRepository.deleteById(id);
    }

    // Domain → Entity
    private ReservaEntity toEntity(Reserva reserva) {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(reserva.getId());
        entity.setFechaReserva(reserva.getFechaReserva().atStartOfDay());
        entity.setCantidadPasajeros(1); // Ajusta si tienes un campo real

        // Cliente → ClienteEntity
        Cliente cliente = reserva.getCliente();
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setDireccion(cliente.getDireccion());
        entity.setCliente(clienteEntity);

        // Viaje → VueloEntity
        Vuelo viaje = reserva.getViaje();
        VueloEntity vueloEntity = new VueloEntity();
        vueloEntity.setId(viaje.getId());
        vueloEntity.setDestino(viaje.getDestino());
        vueloEntity.setOrigen("ORIGEN"); // Temporal, ajusta según tu modelo
        vueloEntity.setFechaSalida(viaje.getFechaInicio().atStartOfDay());
        vueloEntity.setFechaLlegada(viaje.getFechaFin().atStartOfDay());
        vueloEntity.setCapacidad(100); // Temporal
        entity.setVuelo(vueloEntity);

        return entity;
    }

    // Entity → Domain
    private Reserva toDomain(ReservaEntity entity) {
        ClienteEntity ce = entity.getCliente();
        Cliente cliente = new Cliente(
            ce.getId(),
            ce.getNombre(),
            ce.getEmail(),
            ce.getTelefono(),
            ce.getDireccion()
        );

        VueloEntity ve = entity.getVuelo();
        Vuelo viaje = new Vuelo(
            ve.getId(),
            ve.getDestino(),
            ve.getFechaSalida().toLocalDate(),
            ve.getFechaLlegada().toLocalDate(),
            ve.getPrecio(), // usa el precio real en lugar del valor fijo si lo tienes
            "Viaje generado desde vuelo",
            ve.getOrigen()
        );

        return new Reserva(
            entity.getId(),
            cliente,
            viaje,
            entity.getFechaReserva().toLocalDate()
        );
    }

    @Override
    public List<ReservaEntity> findByClienteId(Long clienteId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}