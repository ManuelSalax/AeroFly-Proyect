package com.proyect.proyect_aerofly.Domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyect.proyect_aerofly.Domain.Entities.VueloEntity;

@Repository
public interface VueloRepository extends JpaRepository<VueloEntity, Long> {
}
