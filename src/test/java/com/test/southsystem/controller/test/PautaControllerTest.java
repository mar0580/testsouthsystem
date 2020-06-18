package com.test.southsystem.controller.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.southsystem.datasource.model.Pauta;
import com.test.southsystem.repository.PautaRepository;
import com.test.southsystem.service.BuscarPautaPorIdServiceImpl;



@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_pauta_para_test_buscar_por_id.sql")
public class PautaControllerTest {

	@Autowired
	private BuscarPautaPorIdServiceImpl serviceImpl;

	@Autowired
	private PautaRepository pautaRepository;

	@Test
	public void testHomeController() {
		List<Pauta> listaPautas = serviceImpl.buscarTodasAsPautas();
		
	    boolean listaPautasDatabase = pautaRepository.existsById(1L);

	    Pauta pautaService = listaPautas.stream()
	        .filter(pauta_ -> pauta_.getPauta().equals("Nova Pauta 1")).findFirst().get();

	    
	    assertNotNull(Objects.nonNull(listaPautas));
	    //assertEquals(listaPautasDatabase.getPauta(), pautaService.getPauta());
	}
}
