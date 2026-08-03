package com.justin.Neptunus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pez")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(name = "nombre_cientifico", length = 150)
    private String nombreCientifico;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "tamano_max_cm", precision = 5, scale = 2)
    private BigDecimal tamanoMaxCm;

    @Column(name = "temperatura_min", precision = 4, scale = 1)
    private BigDecimal temperaturaMin;

    @Column(name = "temperatura_max", precision = 4, scale = 1)
    private BigDecimal temperaturaMax;

    @Column(name = "ph_min", precision = 3, scale = 1)
    private BigDecimal phMin;

    @Column(name = "ph_max", precision = 3, scale = 1)
    private BigDecimal phMax;

    @Column(name = "nivel_dificultad", length = 20)
    private String nivelDificultad;

    @Column(nullable = false)
    private Boolean activo = true;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}