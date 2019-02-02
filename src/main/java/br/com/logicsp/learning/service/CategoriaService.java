package br.com.logicsp.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logicsp.learning.domain.Categoria;
import br.com.logicsp.learning.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElse(null);
	}
	
	public List<Categoria> buscarTodos(){
		List<Categoria> categorias = repository.findAll();
		return categorias;
	}
}
