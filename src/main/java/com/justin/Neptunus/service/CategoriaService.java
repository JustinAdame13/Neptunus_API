package com.justin.Neptunus.service;

import com.justin.Neptunus.dto.CategoriaDTO;
import com.justin.Neptunus.model.Categoria;
import com.justin.Neptunus.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listarTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO obtenerPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
        return convertirADTO(categoria);
    }

    public CategoriaDTO crear(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setTipoAgua(dto.getTipoAgua());
        categoria.setDescripcion(dto.getDescripcion());

        Categoria guardada = categoriaRepository.save(categoria);
        return convertirADTO(guardada);
    }

    private CategoriaDTO convertirADTO(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getTipoAgua(),
                categoria.getDescripcion()
        );
    }
}