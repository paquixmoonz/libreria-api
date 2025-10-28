package com.prueba.libreria_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_libro;

    private String titulo;
    private String autor;
    private String descripcion;
    private Double precio;
    private String imagen_url;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;

    @Column(name = "fecha_creacion")
    private java.sql.Timestamp fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private java.sql.Timestamp fechaActualizacion;
}