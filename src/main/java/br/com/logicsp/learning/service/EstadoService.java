package br.com.logicsp.learning.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.logicsp.learning.domain.Estado;
import br.com.logicsp.learning.repositories.EstadoRepository;
import br.com.logicsp.learning.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado buscar(Integer id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return estado.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontado - ID: "+id));
	}
	
	public List<Estado> listarEstados(){
		List<Estado> estados = estadoRepository.findAll();
		return estados;
	}
}
