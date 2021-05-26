package com.laentwicklung.lalogapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laentwicklung.lalogapi.domain.model.Entrega;
import com.laentwicklung.lalogapi.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;

	public FinalizacaoEntregaService(EntregaRepository entregaRepository, BuscaEntregaService buscaEntregaService) {
		super();
		this.entregaRepository = entregaRepository;
		this.buscaEntregaService = buscaEntregaService;
	}

	@Transactional
	public void finalizar(Long entregaId) {

		Entrega entrega = buscaEntregaService.buscar(entregaId);

		entrega.finalizar();

		entregaRepository.save(entrega);
	}
}
