package com.test.southsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.exception.pauta.PautaResourceException;
import com.test.southsystem.repository.PautaRepository;
import com.test.southsystem.resource.model.PautaResource;

@Service
public class CadastroPautaServiceImpl {

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private PautaConversor pautaConversor;

	public void cadastro(PautaResource pautaResource) {	
		
		try {
			Pauta pauta = pautaConversor.setPauta(pautaResource);
			pautaRepository.saveAndFlush(pauta);
		} catch (PautaResourceException e) {
			System.out.println("Erro ao salvar pauta: " + e.getMessage());
		}
	}
}
