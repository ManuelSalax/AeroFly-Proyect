package com.proyect.proyect_aerofly.Infrastructure.jpa;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.ReservaEntity;

@Primary
@Repository
public interface JpaReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByClienteId(Long clienteId);
}