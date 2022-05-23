package com.food.sendfood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private BigDecimal taxaFrete;
	@Column
	private Boolean ativo = true;
	@Column
	private LocalDateTime dataCadastro;
	@Column
	private LocalDateTime dataAtualizacao;
	@Column
	private LocalDateTime horarioFuncionamento;

}
