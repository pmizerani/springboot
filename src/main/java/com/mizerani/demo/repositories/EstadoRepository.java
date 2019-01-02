package com.mizerani.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mizerani.demo.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	Optional<Estado> findById(Integer id);
	
}
