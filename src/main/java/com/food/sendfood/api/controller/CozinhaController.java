package com.food.sendfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.sendfood.domain.model.Cozinha;
import com.food.sendfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinha")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

}
