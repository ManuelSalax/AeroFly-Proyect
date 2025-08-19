package com.proyect.proyect_aerofly.Infrastructure.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.proyect_aerofly.Domain.Entities.UsuarioEntity;

public interface  JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);
}