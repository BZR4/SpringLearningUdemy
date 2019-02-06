package br.com.logicsp.learning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logicsp.learning.domain.Produto;
import br.com.logicsp.learning.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResources {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		Produto produto = produtoService.buscar(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos(){
		List<Produto> produtos = produtoService.buscarTodos();
		return ResponseEntity.ok().body(produtos);
	}
}
