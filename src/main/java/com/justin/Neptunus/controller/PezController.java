package com.justin.Neptunus.controller;

import com.justin.Neptunus.dto.PezDTO;
import com.justin.Neptunus.dto.PezRequestDTO;
import com.justin.Neptunus.service.PezService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peces")
public class PezController {

    @Autowired
    private PezService pezService;

    @GetMapping
    public ResponseEntity<List<PezDTO>> listarTodos() {
        return ResponseEntity.ok(pezService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PezDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pezService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PezDTO> crear(@RequestBody PezRequestDTO dto) {
        PezDTO creado = pezService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PezDTO> actualizar(@PathVariable Long id, @RequestBody PezRequestDTO dto) {
        return ResponseEntity.ok(pezService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pezService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}