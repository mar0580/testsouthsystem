package com.test.southsystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.southsystem.exception.pauta.PautaNotFoundException;
import com.test.southsystem.resource.model.VotoPautaResource;
import com.test.southsystem.service.VotoPautaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class VotoPautaController {

	@Autowired
	private VotoPautaServiceImpl serviceVotoPauta;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/associado/{cpf}")
	public String valida(@PathVariable(name = "cpf", required = true) String cpf) {

		String url = "https://user-info.herokuapp.com/users/{cpf}";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		headers.set("X-Request-Source", "Desktop");

		HttpEntity<?> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class, cpf);

		return response.getStatusCode() == HttpStatus.OK ? response.getBody() : response.getStatusCode().toString();
	}

	@PostMapping(path = "/votoPauta/save")
	public void salvarVotoPauta(@RequestBody VotoPautaResource votoPauta, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> msgs = (List<String>) request.getSession().getAttribute("MY_SESSION_SOUTHSYSTEM");
		if (msgs == null) {
			msgs = new ArrayList<>();
			request.getSession().setAttribute("MY_SESSION_SOUTHSYSTEM", msgs);
		}
		msgs.add("Session");
		request.getSession().setAttribute("MY_SESSION_SOUTHSYSTEM", msgs);
		serviceVotoPauta.realizarVotacao(votoPauta);
	}

	@GetMapping(path = "/contabiliza/votoPauta/id/{id}")
	public Map<String, String> contabilizarPautasPorId(@PathVariable(name = "id", required = true) Long id)
			throws PautaNotFoundException {
		return serviceVotoPauta.contabilizarPautaPorId(id);
	}
}