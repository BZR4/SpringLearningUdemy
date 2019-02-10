package br.com.logicsp.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logicsp.learning.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
