package com.estacionamento.smartparking.controller;

import com.estacionamento.smartparking.model.Reserva;
import com.estacionamento.smartparking.repository.ReservaRepository;
import com.estacionamento.smartparking.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository reservaRepo;
    private final VagaRepository vagaRepo;

    public ReservaController(ReservaRepository reservaRepo, VagaRepository vagaRepo) {
        this.reservaRepo = reservaRepo;
        this.vagaRepo = vagaRepo;
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        var vaga = vagaRepo.findById(reserva.getVaga().getId()).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        vaga.setOcupada(true);
        vagaRepo.save(vaga);

        reserva.setHorarioEntrada(LocalDateTime.now());
        return reservaRepo.save(reserva);
    }

    @PutMapping("/{id}/finalizar")
    public Reserva finalizar(@PathVariable Long id) {
        var reserva = reservaRepo.findById(id).orElseThrow();
        reserva.setHorarioSaida(LocalDateTime.now());

        var vaga = reserva.getVaga();
        vaga.setOcupada(false);
        vagaRepo.save(vaga);

        return reservaRepo.save(reserva);
    }
}
