package com.laentwicklung.lalogapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laentwicklung.lalogapi.api.model.EntregaModel;
import com.laentwicklung.lalogapi.api.model.input.EntregaInput;
import com.laentwicklung.lalogapi.domain.model.Entrega;

@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;

	public EntregaAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}

	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}

	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}

}
