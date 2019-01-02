package com.mizerani.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizerani.demo.domain.Categoria;
import com.mizerani.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}

     public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
     }
}
