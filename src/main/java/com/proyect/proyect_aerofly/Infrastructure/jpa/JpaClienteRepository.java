package com.proyect.proyect_aerofly.Infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.proyect_aerofly.Domain.Entities.ClienteEntity;

public interface JpaClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
