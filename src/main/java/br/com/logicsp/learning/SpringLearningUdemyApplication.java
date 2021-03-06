package br.com.logicsp.learning;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.logicsp.learning.domain.Categoria;
import br.com.logicsp.learning.domain.Cidade;
import br.com.logicsp.learning.domain.Estado;
import br.com.logicsp.learning.domain.Produto;
import br.com.logicsp.learning.repositories.CategoriaRepository;
import br.com.logicsp.learning.repositories.CidadeRepository;
import br.com.logicsp.learning.repositories.EstadoRepository;
import br.com.logicsp.learning.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringLearningUdemyApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.D);
		Produto produto2 = new Produto(null, "Impressora", 800.D);
		Produto produto3 = new Produto(null, "Mouse", 80.D);
		
		/**
		 * Preencher listas para adicionar aos relacionamentos dos objetos
		 */
				
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		
		categoria2.getProdutos().addAll(Arrays.asList(produto2));
				
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		Estado e1 = new Estado(null, "São Paulo");
		Estado e2 = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Campinas",e1);
		Cidade c2 = new Cidade(null, "São Paulo",e1);
		Cidade c3 = new Cidade(null, "Uberlandia",e2);
		
		e1.getCidades().addAll(Arrays.asList(c1,c2));
		e2.getCidades().addAll(Arrays.asList(c3));		
		
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}

