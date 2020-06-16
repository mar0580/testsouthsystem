package com.test.southsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.southsystem.datasource.model.Voto;

@Repository
public interface VotoPautaRepository extends JpaRepository<Voto, Long> {

	boolean existsByIdAssociadoAndIdPauta(Long idAssociado, Long idPauta);

	@Query(value = "SELECT sum(if(substring(v.voto,1,1)='S' ,1,0)) as sim FROM voto v where v.id_pauta = :id", nativeQuery = true)
	String sumVoteYes(@Param("id") Long id);

	@Query(value = "SELECT sum(if(substring(v.voto,1,1)='N' ,1,0)) as nao FROM voto v where v.id_pauta = :id", nativeQuery = true)
	String sumVoteNo(@Param("id") Long id);
}