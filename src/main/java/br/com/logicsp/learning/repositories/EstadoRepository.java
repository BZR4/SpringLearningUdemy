package br.com.logicsp.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.logicsp.learning.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
