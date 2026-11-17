package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Arma;
import com.dt2.gtavi.repositories.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
public class ArmaController {

    private final ArmaRepository repository;
    public ArmaController(ArmaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Arma> mostrar() {
        return repository.findAll();
    }

    @PostMapping
    public String criarArma(@RequestBody Arma armas) {

        try {

            repository.save(armas);
            return "Salvo com Sucessssso ✅";
        }
        catch (Exception e) {

            return "Erro ao soulvar ❌";
        }
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

