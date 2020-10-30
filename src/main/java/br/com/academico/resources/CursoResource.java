package br.com.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.academico.entities.Curso;
import br.com.academico.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.ok().body(cursoService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(cursoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Curso> insert(@RequestBody Curso curso) {
		return ResponseEntity.ok().body(cursoService.insert(curso));
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Curso curso) {
		cursoService.update(id, curso);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		cursoService.delete(id);
	}
	
}
