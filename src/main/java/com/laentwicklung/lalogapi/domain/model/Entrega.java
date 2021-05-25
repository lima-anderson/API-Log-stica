package com.laentwicklung.lalogapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Cliente cliente;

	@Embedded
	private Destinatario destinatario;

	private BigDecimal taxa;

	@Enumerated(EnumType.STRING)
	private StatusEntrega status;

	private OffsetDateTime dataPedido;

	private OffsetDateTime dataFinalização;

	public Entrega() {

	}

	public Entrega(Long id, Cliente cliente, Destinatario destinatario, BigDecimal taxa, StatusEntrega status,
			OffsetDateTime dataPedido, OffsetDateTime dataFinalização) {
		this.id = id;
		this.cliente = cliente;
		this.destinatario = destinatario;
		this.taxa = taxa;
		this.status = status;
		this.dataPedido = dataPedido;
		this.dataFinalização = dataFinalização;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public OffsetDateTime getDataFinalização() {
		return dataFinalização;
	}

	public void setDataFinalização(OffsetDateTime dataFinalização) {
		this.dataFinalização = dataFinalização;
	}

}
