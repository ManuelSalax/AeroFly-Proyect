package com.proyect.proyect_aerofly.Infrastructure.Adapter.JpaAdapter;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.Vuelo;
import com.proyect.proyect_aerofly.Domain.Entities.VueloEntity;
import com.proyect.proyect_aerofly.Domain.Repository.ViajeRepository;
import com.proyect.proyect_aerofly.Infrastructure.jpa.JpaVueloRepository;

@Repository("vueloJpaAdapter") // IMPORTANTE: este nombre lo usarás con @Qualifier
public class VueloJpaAdapter implements ViajeRepository {

    private final JpaVueloRepository jpaVueloRepository;

    public VueloJpaAdapter(JpaVueloRepository jpaVueloRepository) {
        this.jpaVueloRepository = jpaVueloRepository;
    }

    @Override
    public Vuelo guardar(Vuelo vuelo) {
        VueloEntity entity = toEntity(vuelo);
        VueloEntity saved = jpaVueloRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Vuelo> buscarPorId(Long id) {
        return jpaVueloRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Vuelo> buscarPorDestino(String destino) {
        return jpaVueloRepository.findAll().stream()
                .filter(v -> v.getDestino().equalsIgnoreCase(destino))
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vuelo> buscarPorFechas(LocalDate desde, LocalDate hasta) {
        return jpaVueloRepository.findAll().stream()
                .filter(v -> {
                    LocalDate salida = v.getFechaSalida().toLocalDate();
                    return (salida.isEqual(desde) || salida.isAfter(desde)) &&
                           (salida.isEqual(hasta) || salida.isBefore(hasta));
                })
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vuelo> listarTodos() {
        return jpaVueloRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        jpaVueloRepository.deleteById(id);
    }

    private Vuelo toDomain(VueloEntity entity) {
        return new Vuelo(
            entity.getId(),
            entity.getDestino(),
            entity.getFechaSalida().toLocalDate(),
            entity.getFechaLlegada().toLocalDate(),
            entity.getPrecio(), // puedes adaptar si usas precio
            "Vuelo desde " + entity.getOrigen(),
            entity.getOrigen()
        );
    }

    private VueloEntity toEntity(Vuelo vuelo) {
        VueloEntity entity = new VueloEntity();
        entity.setId(vuelo.getId());
        entity.setOrigen(vuelo.getOrigen()); // ✅ ahora sí toma el valor real
        entity.setDestino(vuelo.getDestino());
        entity.setFechaSalida(vuelo.getFechaInicio().atStartOfDay());
        entity.setFechaLlegada(vuelo.getFechaFin().atStartOfDay());
        entity.setCapacidad(100); // puedes adaptar este valor
        entity.setPrecio(vuelo.getPrecio());
        return entity;
    }
}