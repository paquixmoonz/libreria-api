package com.prueba.libreria_api.repository;

import com.prueba.libreria_api.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
