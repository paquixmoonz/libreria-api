package com.prueba.libreria_api.repository;

import com.prueba.libreria_api.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
List<Libro> findByGenero_IdGenero(Integer idGenero);
}
