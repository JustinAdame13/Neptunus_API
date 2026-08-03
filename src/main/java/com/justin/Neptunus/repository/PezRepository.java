package com.justin.Neptunus.repository;

import com.justin.Neptunus.model.Pez;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PezRepository extends JpaRepository<Pez, Long> {

    @Query("SELECT p FROM Pez p JOIN FETCH p.categoria")
    List<Pez> findAllConCategoria();

    @Query("SELECT p FROM Pez p JOIN FETCH p.categoria WHERE p.id = :id")
    Optional<Pez> findByIdConCategoria(Long id);
}