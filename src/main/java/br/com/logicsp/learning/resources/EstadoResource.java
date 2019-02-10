package br.com.logicsp.learning.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.logicsp.learning.domain.Estado;
import br.com.logicsp.learning.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> find(@PathVariable Integer id) {
		Estado estado = estadoService.buscar(id);
		return ResponseEntity.ok().body(estado);
	}
	
	@GetMapping
	public ResponseEntity<List<Estado>> listarEstados(){
		List<Estado> estados = estadoService.listarEstados();
		return ResponseEntity.ok().body(estados);
	}
}
