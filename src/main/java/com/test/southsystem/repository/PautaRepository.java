package com.test.southsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.southsystem.datasource.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

	boolean existsById(Long idPauta);	
	
}
