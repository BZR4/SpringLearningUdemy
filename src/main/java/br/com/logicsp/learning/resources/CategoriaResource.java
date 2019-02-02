package br.com.logicsp.learning.resources;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.logicsp.learning.domain.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@GetMapping
	public List<Categoria> listarCategorias(){
		return Arrays.asList(new Categoria(1, "Informática"),new Categoria(2, "Papelaria"));
	}
}
