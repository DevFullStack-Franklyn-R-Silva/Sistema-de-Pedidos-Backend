package com.github.hadesfranklyn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.github.hadesfranklyn.domain.Categoria;
import com.github.hadesfranklyn.repositories.CategoriaRepository;
import com.github.hadesfranklyn.services.exceptions.DataIntegrityException;
import com.github.hadesfranklyn.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> buscarTodos() {
		return repository.findAll();
	}

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria inserir(Categoria obj) {
		// Verificar se e null
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria atualizar(Categoria obj) {
		// Verificar se objeto existe
		buscar(obj.getId());
		// Atualizar o objeto
		return repository.save(obj);
	}

	public void deletar(Integer id) {
		// Verificar se objeto existe
		buscar(id);

		try {
			// Deleta o objeto
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}
	}

	public Page<Categoria> buscarPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}
