package com.prueba.libreria_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "genero")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Integer idGenero;   // 👈 importante: "G" mayúscula

    private String nombre;
    private String descripcion;
}
