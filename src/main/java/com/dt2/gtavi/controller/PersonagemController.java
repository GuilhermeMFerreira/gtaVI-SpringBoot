package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;
    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void criarPersonagem(@RequestBody Personagem personagem) {
            repository.save(personagem);
    }

    @GetMapping
    public List<Personagem> mostrar() {
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
