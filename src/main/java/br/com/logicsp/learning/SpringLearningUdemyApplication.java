package br.com.logicsp.learning;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.logicsp.learning.domain.Categoria;
import br.com.logicsp.learning.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringLearningUdemyApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearningUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(0, "Informática");
		Categoria categoria2 = new Categoria(0, "Escritório");
		
		repository.saveAll(Arrays.asList(categoria1, categoria2));
	}

}

