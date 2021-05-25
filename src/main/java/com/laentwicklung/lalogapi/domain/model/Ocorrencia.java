package com.laentwicklung.lalogapi.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Entrega entrega;
	private String descricao;
	private OffsetDateTime dataRegistro;

	public Ocorrencia() {

	}

	public Ocorrencia(Long id, Entrega entrega, String descricao, OffsetDateTime daraRegistro) {
		this.id = id;
		this.entrega = entrega;
		this.descricao = descricao;
		this.dataRegistro = daraRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(OffsetDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
