package com.test.southsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.exception.pauta.PautaNotFoundException;
import com.test.southsystem.repository.PautaRepository;

@Service
public class BuscarPautaPorIdServiceImpl {
	@Autowired
	private PautaRepository pautaRepository;	

	public Pauta buscarPorId(Long id) throws PautaNotFoundException {
		Optional<Pauta> optionalPauta = getOptional(id);
		Pauta pauta = null;
		if (!optionalPauta.isPresent()) {
			throw new PautaNotFoundException("Pauta nao encontrada atraves do ID: " + id);
		} else {
			pauta = optionalPauta.get();
		}
		return pauta;
	}

	private Optional<Pauta> getOptional(Long id) {
		Optional<Pauta> optionalPauta = pautaRepository.findById(id);
		return optionalPauta;
	}

	public void deletarPorId(Long id) throws PautaNotFoundException {
		Optional<Pauta> optionalPauta = getOptional(id);
		if (!optionalPauta.isPresent()) {
			throw new PautaNotFoundException("Pauta nao encontrada atraves do ID: " + id);
		} else {
			pautaRepository.delete(optionalPauta.get());
		}
	}

	public List<Pauta> buscarTodasAsPautas() {
		List<Pauta> listPautas = pautaRepository.findAll();
		return listPautas;
	}
}
