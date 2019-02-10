package br.com.logicsp.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logicsp.learning.domain.Produto;
import br.com.logicsp.learning.repositories.ProdutoRepository;
import br.com.logicsp.learning.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));                                                                                                                                     
	}
	
	public List<Produto> buscarTodos(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
}
