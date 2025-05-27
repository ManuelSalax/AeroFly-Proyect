package com.proyect.proyect_aerofly.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepositoryJpa<PagoEntityJpa> extends JpaRepository<PagoEntityJpa, Long> {
}