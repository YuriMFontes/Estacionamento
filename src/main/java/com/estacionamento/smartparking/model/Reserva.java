package com.estacionamento.smartparking.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placaVeiculo;

    private String nomeCondutor;

    private LocalDateTime horarioEntrada;

    private LocalDateTime horarioSaida;

    @ManyToOne
    private Vaga vaga;
}
