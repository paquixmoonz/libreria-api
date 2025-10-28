package com.prueba.libreria_api.controller;

import com.prueba.libreria_api.entity.Usuario;
import com.prueba.libreria_api.repository.UsuarioRepository;
import com.prueba.libreria_api.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> datos) {
        String username = datos.get("username");
        String password = datos.get("password");

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassword_hash().equals(password)) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtUtil.generarToken(username);

        return Map.of(
                "mensaje", "Login exitoso",
                "usuario", usuario.getUsername(),
                "rol", usuario.getRol(),
                "token", token
        );
    }
}
