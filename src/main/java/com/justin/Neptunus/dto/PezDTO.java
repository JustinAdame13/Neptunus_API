package com.justin.Neptunus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PezDTO {
    private Long id;
    private Long categoriaId;
    private String categoriaNombre;
    private String nombre;
    private String nombreCientifico;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private BigDecimal tamanoMaxCm;
    private BigDecimal temperaturaMin;
    private BigDecimal temperaturaMax;
    private BigDecimal phMin;
    private BigDecimal phMax;
    private String nivelDificultad;
    private Boolean activo;
}