package com.test.southsystem.service;

import org.springframework.stereotype.Component;

import com.test.southsystem.datasource.model.Voto;
import com.test.southsystem.exception.votopauta.VotoPautaResourceException;
import com.test.southsystem.resource.model.VotoPautaResource;

@Component
public class VotoPautaConversor {

	public Voto setVotoPauta(VotoPautaResource pautaResource) throws VotoPautaResourceException {

		try {
			Voto votoPauta = new Voto();

			votoPauta.setId(pautaResource.getId());
			votoPauta.setVoto(pautaResource.getVoto().toUpperCase());
			votoPauta.setIdAssociado(pautaResource.getIdAssociado());
			votoPauta.setIdPauta(pautaResource.getIdPauta());

			return votoPauta;

		} catch (Exception e) {
			throw new VotoPautaResourceException(
					"Falha ao converter o resource para entidade, resouce: " + pautaResource);
		}
	}

	

}