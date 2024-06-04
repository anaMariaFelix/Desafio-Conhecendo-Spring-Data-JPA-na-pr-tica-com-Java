package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService service;
	
	@PostMapping
	public Matricula createMatricula(@Valid @RequestBody MatriculaForm form ) {
		return service.create(form);
	}
	
	@GetMapping("/getMatricula")
	public Matricula getMatricula(@RequestBody MatriculaForm form) {
		return service.get(form.getAlunoId());
	}
	
	@GetMapping("/getAll")
	public List<Matricula> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/getAllAlunoBairro")
	public List<Matricula> getAllAlunoBairro(@RequestParam(value = "bairro", required = false) String bairro) {
		return service.findByAlunoBairro(bairro);
	}
	
	@DeleteMapping("/{id}")
	public void removeMatriculaById(@PathVariable Long id){
		
		service.delete(id);
	}
	
}
