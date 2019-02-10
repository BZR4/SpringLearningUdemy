package br.com.logicsp.learning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logicsp.learning.domain.Cidade;
import br.com.logicsp.learning.service.CidadeService;

@RestController
@RequestMapping("cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> find(@PathVariable Integer id){
		Cidade cidade = cidadeService.buscar(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@GetMapping
	public ResponseEntity<List<Cidade>> listarCidades(){
		List<Cidade> cidades = cidadeService.buscarTodas();
		return ResponseEntity.ok().body(cidades);
	}
	
}
