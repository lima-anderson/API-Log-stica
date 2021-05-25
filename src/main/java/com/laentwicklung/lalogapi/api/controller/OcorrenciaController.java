package com.laentwicklung.lalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.laentwicklung.lalogapi.api.assembler.OcorrenciaAssembler;
import com.laentwicklung.lalogapi.api.model.OcorrenciaModel;
import com.laentwicklung.lalogapi.api.model.input.OcorrenciaInput;
import com.laentwicklung.lalogapi.domain.model.Entrega;
import com.laentwicklung.lalogapi.domain.model.Ocorrencia;
import com.laentwicklung.lalogapi.domain.service.BuscaEntregaService;
import com.laentwicklung.lalogapi.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	BuscaEntregaService buscaEntregaService;
	RegistroOcorrenciaService registroOcorrenciaService;
	OcorrenciaAssembler ocorrenciaAssembler;

	public OcorrenciaController(BuscaEntregaService buscaEntregaService,
			RegistroOcorrenciaService registroOcorrenciaService, OcorrenciaAssembler ocorrenciaAssembler) {
		this.buscaEntregaService = buscaEntregaService;
		this.registroOcorrenciaService = registroOcorrenciaService;
		this.ocorrenciaAssembler = ocorrenciaAssembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrarda = registroOcorrenciaService.registrar(entregaId,
				ocorrenciaInput.getDescricao());

		return ocorrenciaAssembler.toModel(ocorrenciaRegistrarda);
	}

	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {

		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}

}
