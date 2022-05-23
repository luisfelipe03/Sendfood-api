package com.food.sendfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.sendfood.domain.model.Cozinha;
import com.food.sendfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value = "/cozinha")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.findAll();
	}
	
	@GetMapping(path = { "/{id}" })
    public ResponseEntity<Cozinha> findById(@PathVariable long id) {
        return cozinhaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}
