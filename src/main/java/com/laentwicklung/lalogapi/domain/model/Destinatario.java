package com.laentwicklung.lalogapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Destinatario {

	@Column(name = "destinatario_nome")
	private String nome;

	@Column(name = "destinatario_logradouro")
	private String logradouro;

	@Column(name = "destinatario_numero")
	private String numero;

	@Column(name = "destinatario_complemento")
	private String complemento;

	@Column(name = "destinatario_bairro")
	private String bairro;

	public Destinatario() {

	}

	public Destinatario(String nome, String logradouro, String numero, String complemento, String bairro) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}