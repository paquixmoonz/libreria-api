package com.prueba.libreria_api.controller;

import com.prueba.libreria_api.entity.Genero;
import com.prueba.libreria_api.repository.GeneroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "http://localhost:5173") 
public class GeneroController {

    private final GeneroRepository generoRepository;

    public GeneroController(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }
}