package com.proyect.proyect_aerofly.Infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.proyect_aerofly.Domain.Entities.PagoEntity;

public interface JpaPagoRepository extends JpaRepository<PagoEntity, Long> {
}
