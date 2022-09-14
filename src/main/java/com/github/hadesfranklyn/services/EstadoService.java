package com.github.hadesfranklyn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.domain.Estado;
import com.github.hadesfranklyn.repositories.EstadoRepository;
import com.github.hadesfranklyn.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public Estado buscar(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Estado não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
}
