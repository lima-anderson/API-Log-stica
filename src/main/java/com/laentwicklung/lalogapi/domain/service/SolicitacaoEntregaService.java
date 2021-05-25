package com.laentwicklung.lalogapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laentwicklung.lalogapi.domain.model.Cliente;
import com.laentwicklung.lalogapi.domain.model.Entrega;
import com.laentwicklung.lalogapi.domain.model.StatusEntrega;
import com.laentwicklung.lalogapi.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;

	public SolicitacaoEntregaService(CatalogoClienteService catalogoClienteService,
			EntregaRepository entregaRepository) {
		this.catalogoClienteService = catalogoClienteService;
		this.entregaRepository = entregaRepository;
	}

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return entregaRepository.save(entrega);
	}

}
