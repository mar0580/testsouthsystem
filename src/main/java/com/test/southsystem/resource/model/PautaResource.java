package com.test.southsystem.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PautaResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4509503651916842439L;

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String pauta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
	
	@Override
	  public String toString() {
	    return "PautaResource [pauta=" + pauta + "]";
	  }
}
