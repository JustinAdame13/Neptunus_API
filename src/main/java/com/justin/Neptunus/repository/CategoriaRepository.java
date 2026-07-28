package com.justin.Neptunus.repository;

import com.justin.Neptunus.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}