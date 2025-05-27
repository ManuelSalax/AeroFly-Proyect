package com.proyect.proyect_aerofly.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.proyect_aerofly.Domain.Entities.ReservaEntity;

public interface  ReservaRepositoryJpa extends JpaRepository<ReservaEntity, Long> {
}
