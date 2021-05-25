package com.laentwicklung.lalogapi.api.model.input;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {

	@NotNull
	private Long id;

	public ClienteIdInput() {

	}

	public ClienteIdInput(@NotNull Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
