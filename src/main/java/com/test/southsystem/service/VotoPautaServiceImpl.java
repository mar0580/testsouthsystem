package com.test.southsystem.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.southsystem.datasource.model.Voto;
import com.test.southsystem.exception.pauta.PautaNotFoundException;
import com.test.southsystem.exception.votopauta.VotoPautaResourceException;
import com.test.southsystem.repository.PautaRepository;
import com.test.southsystem.repository.VotoPautaRepository;
import com.test.southsystem.resource.model.VotoPautaResource;

@Service
public class VotoPautaServiceImpl {
	@Autowired
	private VotoPautaRepository votoPautaRepository;

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private BuscarPautaPorIdServiceImpl buscaPorIdImpl;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private VotoPautaConversor votoPautaService;

	public void realizarVotacao(VotoPautaResource votoPautaResource) {

		try {
			Voto votoPauta = votoPautaService.setVotoPauta(votoPautaResource);

			if (pautaRepository.existsById(votoPauta.getIdPauta())) {
				
				if (!votoPautaRepository.existsByIdAssociadoAndIdPauta(votoPauta.getIdAssociado(),
						votoPauta.getIdPauta())) {
					votoPautaRepository.saveAndFlush(votoPauta);
				} else {
					System.out.println("Voce havia votado nessa pauta");
				}
			} else {
				System.out.println("Pauta não existe");
			}

		} catch (VotoPautaResourceException e) {
			System.out.println("Erro ao salvar o voto da pauta: " + e.getMessage());
		}
	}

	public Map<String, String> contabilizarPautaPorId(Long id) throws PautaNotFoundException {

		HashMap<String, String> resultado = new HashMap<String, String>();
		if (buscaPorIdImpl.buscarPorId(id) == null) {
			throw new PautaNotFoundException("Pauta nao encontrada atraves do ID: " + id);
		} else {
			resultado.put("Sim", votoPautaRepository.sumVoteYes(id));
			resultado.put("Não", votoPautaRepository.sumVoteNo(id));
		}
		return resultado;
	}
}
