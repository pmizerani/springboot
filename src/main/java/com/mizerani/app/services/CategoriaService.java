package com.mizerani.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizerani.app.domain.Categoria;
import com.mizerani.app.repositories.CategoriaRepository;
import com.mizerani.app.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrato id: " + id + ", Tipo: " + Categoria.class.getName()) );
		
	}
	
}
