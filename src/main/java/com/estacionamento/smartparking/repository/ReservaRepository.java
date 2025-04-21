package com.estacionamento.smartparking.repository;

import com.estacionamento.smartparking.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
