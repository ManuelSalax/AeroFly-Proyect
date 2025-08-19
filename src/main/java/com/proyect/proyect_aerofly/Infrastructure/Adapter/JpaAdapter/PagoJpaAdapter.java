package com.proyect.proyect_aerofly.Infrastructure.Adapter.JpaAdapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Cliente;
import com.proyect.proyect_aerofly.Domain.Entities.ClienteEntity;
import com.proyect.proyect_aerofly.Domain.Entities.Pago;
import com.proyect.proyect_aerofly.Domain.Entities.PagoEntity;
import com.proyect.proyect_aerofly.Domain.Entities.Reserva;
import com.proyect.proyect_aerofly.Domain.Entities.ReservaEntity;
import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Entities.VueloEntity;
import com.proyect.proyect_aerofly.Domain.Repository.PagoRepository;
import com.proyect.proyect_aerofly.Infrastructure.jpa.JpaPagoRepository;

@Repository
public class PagoJpaAdapter implements PagoRepository {

    private final JpaPagoRepository jpaPagoRepository;

    public PagoJpaAdapter(JpaPagoRepository jpaPagoRepository) {
        this.jpaPagoRepository = jpaPagoRepository;
    }

    @Override
    public Pago guardar(Pago pago, Reserva reserva) {
        PagoEntity entity = new PagoEntity();
        entity.setId(pago.getId());
        entity.setMonto(pago.getMonto().doubleValue());
        entity.setMetodoPago(pago.getMetodoPago());
        entity.setFechaPago(pago.getFechaPago().atStartOfDay());
        entity.setReserva(toEntity(reserva));

        PagoEntity saved = jpaPagoRepository.save(entity);
        return toDomain(saved);
    }
    

    private Pago toDomain(PagoEntity entity) {
        ReservaEntity reservaEntity = entity.getReserva();
        ClienteEntity ce = reservaEntity.getCliente();
        Cliente cliente = new Cliente(
            ce.getId(),
            ce.getNombre(),
            ce.getEmail(),
            ce.getTelefono(),
            ce.getDireccion()
        );

    VueloEntity ve = entity.getReserva().getVuelo();

        Vuelo viaje = new Vuelo(
            ve.getId(),
            ve.getDestino(),
            ve.getFechaSalida().toLocalDate(),
            ve.getFechaLlegada().toLocalDate(),
            ve.getPrecio(),
            "Viaje generado desde vuelo",
            ve.getOrigen()
        );

        Reserva reserva = new Reserva(
            reservaEntity.getId(),
            cliente,
            viaje,
            reservaEntity.getFechaReserva().toLocalDate()
        );

        return new Pago(
            entity.getId(),
            reserva,
            BigDecimal.valueOf(entity.getMonto()),
            entity.getMetodoPago(),
            entity.getFechaPago().toLocalDate()
        );
    }

    private ReservaEntity toEntity(Reserva reserva) {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(reserva.getId());

        Cliente cliente = reserva.getCliente();
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(cliente.getId());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setDireccion(cliente.getDireccion());
        entity.setCliente(clienteEntity);

        Vuelo viaje = reserva.getViaje();
        VueloEntity vueloEntity = new VueloEntity();
        vueloEntity.setId(viaje.getId());
        vueloEntity.setDestino(viaje.getDestino());
        vueloEntity.setOrigen("ORIGEN"); // Dummy
        vueloEntity.setFechaSalida(viaje.getFechaInicio().atStartOfDay());
        vueloEntity.setFechaLlegada(viaje.getFechaFin().atStartOfDay());
        vueloEntity.setCapacidad(100);
        entity.setVuelo(vueloEntity);

        entity.setFechaReserva(reserva.getFechaReserva().atStartOfDay());
        entity.setCantidadPasajeros(1); // Dummy

        return entity;
    }

    @Override
    public Pago guardar(Pago pago) {
        throw new UnsupportedOperationException("No implementado aún.");
    }

    @Override
    public Optional<Pago> buscarPorId(Long id) {
        throw new UnsupportedOperationException("No implementado aún.");
    }

    @Override
    public List<Pago> listarPorReserva(Long reservaId) {
        throw new UnsupportedOperationException("No implementado aún.");
    }

    @Override
    public List<Pago> listarTodos() {
        return jpaPagoRepository.findAll()
            .stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        throw new UnsupportedOperationException("No implementado aún.");
    }
}