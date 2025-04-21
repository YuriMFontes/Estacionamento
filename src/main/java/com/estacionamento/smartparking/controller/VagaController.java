package com.estacionamento.smartparking.controller;

import com.estacionamento.smartparking.model.Vaga;
import com.estacionamento.smartparking.repository.VagaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaRepository repository;

    public VagaController(VagaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Vaga> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        return repository.save(vaga);
    }

    @PutMapping("/{id}/ocupar")
    public Vaga ocupar(@PathVariable Long id) {
        Vaga vaga = repository.findById(id).orElseThrow();
        vaga.setOcupada(true);
        return repository.save(vaga);
    }

    @PutMapping("/{id}/liberar")
    public Vaga liberar(@PathVariable Long id) {
        Vaga vaga = repository.findById(id).orElseThrow();
        vaga.setOcupada(false);
        return repository.save(vaga);
    }
}
