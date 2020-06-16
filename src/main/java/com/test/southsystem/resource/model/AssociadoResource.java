package com.test.southsystem.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssociadoResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4453598346805938854L;

	@JsonProperty
	private Long id;

	@JsonProperty
	private String cpfAssociado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfAssociado() {
		return cpfAssociado;
	}

	public void setCpfAssociado(String cpfAssociado) {
		this.cpfAssociado = cpfAssociado;
	}
}
