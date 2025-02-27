package org.example.repositories;

import org.example.models.MathExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MathExampleRepository extends JpaRepository<MathExample, Long> {
}
