package com.food.sendfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.food.sendfood.domain.exception.EntidadeEmUsoException;
import com.food.sendfood.domain.exception.EntidadeNaoEncontradaException;
import com.food.sendfood.domain.model.Cozinha;
import com.food.sendfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public void remover(Long id) {
		try {
			cozinhaRepository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Cozinha de codigo %d nao encontrado", id));
		} 
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d nao pode ser removida, pois esta em uso", id));
		}
	}

}
