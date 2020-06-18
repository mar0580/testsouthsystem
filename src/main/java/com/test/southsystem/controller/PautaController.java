package com.test.southsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.exception.pauta.PautaNotFoundException;
import com.test.southsystem.resource.model.PautaResource;
import com.test.southsystem.service.BuscarPautaPorIdServiceImpl;
import com.test.southsystem.service.CadastroPautaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class PautaController {

	@Autowired
	private BuscarPautaPorIdServiceImpl serviceBuscarPauta;

	@Autowired
	private CadastroPautaServiceImpl serviceCadastro;

	@GetMapping(path = "/pautas")
	public List<Pauta>listaPautas() {
		return serviceBuscarPauta.buscarTodasAsPautas();
	}

	@GetMapping(path = "/pauta/id/{id}")
	public Pauta buscaPautaPorId(@PathVariable(name = "id", required = true) Long id) throws PautaNotFoundException {
		return serviceBuscarPauta.buscarPorId(id);
	}

	@PostMapping(path = "/pauta/save")
	public void salvaPauta(@RequestBody PautaResource pauta) {
		serviceCadastro.cadastro(pauta);
	}

	@DeleteMapping(path = "/pauta/delete/{id}")
	public void deletaPauta(@PathVariable(name = "id", required = true) Long id) throws PautaNotFoundException {
		serviceBuscarPauta.deletarPorId(id);
	}

}