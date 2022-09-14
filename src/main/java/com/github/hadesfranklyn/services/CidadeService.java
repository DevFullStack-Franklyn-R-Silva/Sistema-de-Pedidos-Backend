package com.github.hadesfranklyn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.domain.Cidade;
import com.github.hadesfranklyn.repositories.CidadeRepository;
import com.github.hadesfranklyn.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cidade não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
}
