package br.com.logicsp.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.logicsp.learning.domain.Cidade;
import br.com.logicsp.learning.repositories.CidadeRepository;
import br.com.logicsp.learning.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado - ID: "+id));
	}
	
	public List<Cidade> buscarTodas(){
		List<Cidade> cidades = cidadeRepository.findAll();
		return cidades;
	}
}
