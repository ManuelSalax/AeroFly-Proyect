package com.proyect.proyect_aerofly.Infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.PagoEntity;

@Repository
public interface PagoRepositoryJpa extends JpaRepository<PagoEntity, Long> {
}
