package org.example.repositories;

import org.example.models.MathExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Rozhranie pre prácu s entitou MathExample v databáze.
 * Poskytuje základné CRUD operácie dedené z JpaReepository.
 */
public interface MathExampleRepository extends JpaRepository<MathExample, Long> {
}
