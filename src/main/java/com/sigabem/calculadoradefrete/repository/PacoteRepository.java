package com.sigabem.calculadoradefrete.repository;

import com.sigabem.calculadoradefrete.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Integer> {
}
