package com.test.southsystem.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.repository.PautaRepository;
import com.test.southsystem.resource.model.PautaResource;
import com.test.southsystem.service.BuscarPautaPorIdServiceImpl;
import com.test.southsystem.service.CadastroPautaServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_pauta_para_test_buscar_por_id.sql")
public class PautaControllerTest {

	@Autowired
	private BuscarPautaPorIdServiceImpl buscarPautaServiceImpl;

	@Autowired
	private CadastroPautaServiceImpl cadastroPautaServiceImpl;

	@Autowired
	private PautaRepository pautaRepository;

	PautaResource pautaResource;

	@Before
	public void setUp() {
		pautaResource = new PautaResource();
		pautaResource.setPauta("Nova Pauta Test @Before");
	}

	@Test
	public void buscarPautasPorIdTest() {
		assertTrue(pautaRepository.existsById(1L));
	}

	@Test
	public void listaPautasTest() {
		List<Pauta> listaPautas = buscarPautaServiceImpl.buscarTodasAsPautas();
		assertNotNull(Objects.nonNull(listaPautas));
	}

	@Test
	public void salvaPauta() {
		cadastroPautaServiceImpl.cadastro(pautaResource);

		Pauta pauta = pautaRepository.findAll().stream()
				.filter(pauta_ -> pauta_.getPauta().equals("Nova Pauta Test @Before")).findFirst().get();

		assertEquals("Nova Pauta Test @Before", pauta.getPauta());
	}
}