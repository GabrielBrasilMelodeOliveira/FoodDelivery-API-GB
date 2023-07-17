package com.fooddelivery.fooddeliveryapi.controller;

import com.fooddelivery.fooddeliveryapi.domain.model.Cozinha;
import com.fooddelivery.fooddeliveryapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
    @Autowired
    private CozinhaRepository cozinhaRepository;
    @GetMapping
    public List<Cozinha> listar(){
       return cozinhaRepository.listarTodasCozinhas();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id){
        Cozinha cozinha = cozinhaRepository.buscarPorId(id);
        return ResponseEntity.ok(cozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody Cozinha cozinha){
        cozinhaRepository.adicionar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,@RequestBody Cozinha cozinha){
        Cozinha cozinhaAtual = cozinhaRepository.buscarPorId(cozinhaId);
        cozinhaAtual.setNome(cozinha.getNome());
        return  ResponseEntity.ok(cozinhaAtual);
    }

}
