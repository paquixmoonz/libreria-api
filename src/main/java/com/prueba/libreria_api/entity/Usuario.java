package com.prueba.libreria_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String nombre;
    private String apellido;
    private String correo;
    private String username;
    private String password_hash;
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(name = "fecha_registro")
    private java.sql.Timestamp fechaRegistro;

    public enum Rol {
        ADMIN, USER
    }
}