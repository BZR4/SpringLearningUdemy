package br.com.logicsp.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logicsp.learning.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
