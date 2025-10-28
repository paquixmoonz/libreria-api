package com.prueba.libreria_api.controller;

import com.prueba.libreria_api.entity.Libro;
import com.prueba.libreria_api.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:5173")
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Listar libros (con filtro opcional por género)
    @GetMapping
    public List<Libro> listarLibros(@RequestParam(required = false) Integer genero) {
        if (genero != null) {
            return libroRepository.findByGenero_IdGenero(genero);
        }
        return libroRepository.findAll();
    }

    // Detalle por ID
    @GetMapping("/{id}")
    public Optional<Libro> detalleLibro(@PathVariable Integer id) {
        return libroRepository.findById(id);
    }

    // Actualizar libro
    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Integer id, @RequestBody Libro nuevo) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(nuevo.getTitulo());
            libro.setAutor(nuevo.getAutor());
            libro.setDescripcion(nuevo.getDescripcion());
            libro.setPrecio(nuevo.getPrecio());
            libro.setImagen_url(nuevo.getImagen_url());
            libro.setStock(nuevo.getStock());
            libro.setGenero(nuevo.getGenero());
            return libroRepository.save(libro);
        }).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }
}
