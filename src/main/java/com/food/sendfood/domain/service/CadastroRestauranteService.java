package com.food.sendfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.sendfood.domain.model.Restaurante;
import com.food.sendfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	
	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}
}
