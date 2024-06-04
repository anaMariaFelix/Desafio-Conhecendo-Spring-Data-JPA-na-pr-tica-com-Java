package me.dio.academia.digital.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;

@Service
public class MatriculaService implements IMatriculaService{
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		Matricula matricula = Matricula.builder()
				.aluno(aluno)
				.dataDaMatricula(LocalDateTime.now())
				.build();
		
		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
	
		return matriculaRepository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll() {
		
		return matriculaRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		matriculaRepository.deleteById(id);
		
	}

	@Override
	public List<Matricula> findByAlunoBairro(String bairro) {
		if(bairro == null) {
			return matriculaRepository.findAll();
		}else {
			return matriculaRepository.findByAlunoBairro(bairro);
		}
		
	}

}
