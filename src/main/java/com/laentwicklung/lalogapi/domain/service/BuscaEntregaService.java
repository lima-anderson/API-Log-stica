package com.laentwicklung.lalogapi.domain.service;

import org.springframework.stereotype.Service;

import com.laentwicklung.lalogapi.domain.exception.EntidadeNaoEncontradaException;
import com.laentwicklung.lalogapi.domain.model.Entrega;
import com.laentwicklung.lalogapi.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	EntregaRepository entregaRepository;

	public BuscaEntregaService(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
