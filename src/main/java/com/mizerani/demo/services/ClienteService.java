package com.mizerani.demo.services;

import java.util.List;
import java.util.Optional;

import com.mizerani.demo.domain.Cliente;
import com.mizerani.demo.dto.ClienteDTO;
import com.mizerani.demo.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mizerani.demo.domain.Cliente;
import com.mizerani.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElse(null);
	}

	public Cliente update(Cliente obj) {
		Cliente clienteBanco = find(obj.getId());
		updateData(clienteBanco, obj);
		return clienteRepository.save(clienteBanco);
	}

	private void updateData(Cliente clienteBanco, Cliente obj) {
		clienteBanco.setNome(obj.getNome());
		clienteBanco.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		find(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas.");
		}
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
	}

}
