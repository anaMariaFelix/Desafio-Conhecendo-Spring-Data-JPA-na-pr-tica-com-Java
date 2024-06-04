package me.dio.academia.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoServiceImpl service;
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@PutMapping("/update/{id}")
	public Aluno update(@PathVariable  long id , @RequestBody AlunoUpdateForm form) {
		return service.update(id, form);
	}
	
	@GetMapping("/getById/{id}")
	public Aluno getById(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaAlunoId( @PathVariable Long id){ //@PathVariable faz referencia ao id que irar ser passado na requisição /avaliacoes/{id} esse id é do aluno
		return service.getAllAvaliacaoFisicaAlunoId(id); //id do aluno
	}
	
	@GetMapping
	public List<Aluno> getAll(){
		
		return service.getAll();
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeById(@PathVariable Long id){
		
		service.delete(id);
	}
	
	@GetMapping("/getAllDataDeNascimento")
	public List<Aluno> getAllDataDeNascimento(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){ //required = false quer dizer q eu posso receber ou n uma datadenascimento
		return service.getAllDataDeNascimento(dataDeNascimento);
	}
	
	
	
	
}
