package com.test.southsystem.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VotoPautaResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5766087026172724065L;

	@JsonProperty
	private Long id;

	@JsonProperty
	private String voto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	@JsonProperty
	private Long idPauta;

	@JsonProperty
	private Long idAssociado;

	
}
