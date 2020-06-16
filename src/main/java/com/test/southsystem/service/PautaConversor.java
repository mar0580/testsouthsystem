package com.test.southsystem.service;

import org.springframework.stereotype.Component;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.exception.pauta.PautaResourceException;
import com.test.southsystem.resource.model.PautaResource;

@Component
public class PautaConversor {

	public Pauta setPauta(PautaResource pautaResource) throws PautaResourceException {

		try {
			Pauta pauta = new Pauta();

			pauta.setId(pautaResource.getId());
			pauta.setPauta(pautaResource.getPauta());
			return pauta;

		} catch (Exception e) {
			throw new PautaResourceException("Falha ao converter o resource para entidade, resouce: " + pautaResource);
		}
	}
}