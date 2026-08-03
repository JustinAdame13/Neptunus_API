package com.justin.Neptunus.service;

import com.justin.Neptunus.dto.PezDTO;
import com.justin.Neptunus.dto.PezRequestDTO;
import com.justin.Neptunus.model.Categoria;
import com.justin.Neptunus.model.Pez;
import com.justin.Neptunus.repository.CategoriaRepository;
import com.justin.Neptunus.repository.PezRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PezService {

    @Autowired
    private PezRepository pezRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<PezDTO> listarTodos() {
        return pezRepository.findAllConCategoria()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public PezDTO obtenerPorId(Long id) {
        Pez pez = pezRepository.findByIdConCategoria(id)
                .orElseThrow(() -> new RuntimeException("Pez no encontrado con id: " + id));
        return convertirADTO(pez);
    }

    public PezDTO crear(PezRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + dto.getCategoriaId()));

        Pez pez = new Pez();
        pez.setCategoria(categoria);
        pez.setNombre(dto.getNombre());
        pez.setNombreCientifico(dto.getNombreCientifico());
        pez.setDescripcion(dto.getDescripcion());
        pez.setPrecio(dto.getPrecio());
        pez.setStock(dto.getStock());
        pez.setTamanoMaxCm(dto.getTamanoMaxCm());
        pez.setTemperaturaMin(dto.getTemperaturaMin());
        pez.setTemperaturaMax(dto.getTemperaturaMax());
        pez.setPhMin(dto.getPhMin());
        pez.setPhMax(dto.getPhMax());
        pez.setNivelDificultad(dto.getNivelDificultad());
        pez.setActivo(true);

        Pez guardado = pezRepository.save(pez);
        return convertirADTO(guardado);
    }

    private PezDTO convertirADTO(Pez pez) {
        return new PezDTO(
                pez.getId(),
                pez.getCategoria().getId(),
                pez.getCategoria().getNombre(),
                pez.getNombre(),
                pez.getNombreCientifico(),
                pez.getDescripcion(),
                pez.getPrecio(),
                pez.getStock(),
                pez.getTamanoMaxCm(),
                pez.getTemperaturaMin(),
                pez.getTemperaturaMax(),
                pez.getPhMin(),
                pez.getPhMax(),
                pez.getNivelDificultad(),
                pez.getActivo()
        );
    }
    @Transactional
    public PezDTO actualizar(Long id, PezRequestDTO dto) {
        Pez pez = pezRepository.findByIdConCategoria(id)
                .orElseThrow(() -> new RuntimeException("Pez no encontrado con id: " + id));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + dto.getCategoriaId()));

        pez.setCategoria(categoria);
        pez.setNombre(dto.getNombre());
        pez.setNombreCientifico(dto.getNombreCientifico());
        pez.setDescripcion(dto.getDescripcion());
        pez.setPrecio(dto.getPrecio());
        pez.setStock(dto.getStock());
        pez.setTamanoMaxCm(dto.getTamanoMaxCm());
        pez.setTemperaturaMin(dto.getTemperaturaMin());
        pez.setTemperaturaMax(dto.getTemperaturaMax());
        pez.setPhMin(dto.getPhMin());
        pez.setPhMax(dto.getPhMax());
        pez.setNivelDificultad(dto.getNivelDificultad());

        Pez actualizado = pezRepository.save(pez);
        return convertirADTO(actualizado);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!pezRepository.existsById(id)) {
            throw new RuntimeException("Pez no encontrado con id: " + id);
        }
        pezRepository.deleteById(id);
    }
}