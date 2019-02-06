package br.com.logicsp.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logicsp.learning.domain.Produto;
import br.com.logicsp.learning.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto buscar(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElse(null);                                                                                                                                      
	}
	
	public List<Produto> buscarTodos(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
}
