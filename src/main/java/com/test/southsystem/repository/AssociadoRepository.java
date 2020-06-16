package com.test.southsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.southsystem.datasource.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
