package com.food.sendfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.sendfood.domain.exception.EntidadeNaoEncontradaException;
import com.food.sendfood.domain.model.Cozinha;
import com.food.sendfood.domain.model.Restaurante;
import com.food.sendfood.domain.repository.CozinhaRepository;
import com.food.sendfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId).get();
		
		if (cozinhaId == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
}
