package br.com.logicsp.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logicsp.learning.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
