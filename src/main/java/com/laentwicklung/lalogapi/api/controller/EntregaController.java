package com.laentwicklung.lalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.laentwicklung.lalogapi.api.assembler.EntregaAssembler;
import com.laentwicklung.lalogapi.api.model.EntregaModel;
import com.laentwicklung.lalogapi.api.model.input.EntregaInput;
import com.laentwicklung.lalogapi.domain.model.Entrega;
import com.laentwicklung.lalogapi.domain.repository.EntregaRepository;
import com.laentwicklung.lalogapi.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;

	public EntregaController(EntregaRepository entregaRepository, SolicitacaoEntregaService solicitacaoEntregaService,
			EntregaAssembler entregaAssembler) {
		this.entregaRepository = entregaRepository;
		this.solicitacaoEntregaService = solicitacaoEntregaService;
		this.entregaAssembler = entregaAssembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);

		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}

	@GetMapping("/{idEntrega}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long idEntrega) {

		return entregaRepository.findById(idEntrega)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());

	}

}
