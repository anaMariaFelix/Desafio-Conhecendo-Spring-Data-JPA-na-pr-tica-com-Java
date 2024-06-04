package me.dio.academia.digital.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		AvaliacaoFisica avaliacaoFisica = AvaliacaoFisica.builder()
				.aluno(aluno)
				.altura(form.getAltura())
				.peso(form.getPeso()).dataDaAvaliacao(LocalDateTime.now())
				.build();
	
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
	
		return avaliacaoFisicaRepository.getById(id);
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacao =	avaliacaoFisicaRepository.getById(id);
		avaliacao.setAltura(formUpdate.getAltura());
		avaliacao.setPeso(formUpdate.getPeso());
		
		return avaliacaoFisicaRepository.save(avaliacao);
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
		
	}

}
