package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Missao;
import com.dt2.gtavi.repositories.MissaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/missoes")
public class MissaoController {

    private final MissaoRepository repository;

    public MissaoController(MissaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void criarMissao(@RequestBody Missao missao) {
        repository.save(missao);
    }

    @GetMapping
    public List<Missao> mostrar() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {

        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id) {
        repository.findById(id);
    }
}
