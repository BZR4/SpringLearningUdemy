package br.com.logicsp.learning;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.logicsp.learning.domain.Categoria;
import br.com.logicsp.learning.domain.Produto;
import br.com.logicsp.learning.repositories.CategoriaRepository;
import br.com.logicsp.learning.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringLearningUdemyApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(1, "Informática");
		Categoria categoria2 = new Categoria(2, "Escritório");
		
		Produto produto1 = new Produto(1, "Computador", 2000.D);
		Produto produto2 = new Produto(2, "Impressora", 800.D);
		Produto produto3 = new Produto(3, "Mouse", 80.D);
		
		/**
		 * Preencher listas para adicionar aos relacionamentos dos objetos
		 */
		
//		categoria1.setProdutos(Arrays.asList(produto1, produto2, produto3));
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
		
//		categoria2.setProdutos(Arrays.asList(produto2));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		
	}

}

