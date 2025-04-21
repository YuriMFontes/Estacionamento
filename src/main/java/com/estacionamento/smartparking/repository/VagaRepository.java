package com.estacionamento.smartparking.repository;

import com.estacionamento.smartparking.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
