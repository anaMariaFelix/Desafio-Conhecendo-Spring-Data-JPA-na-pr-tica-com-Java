package me.dio.academia.digital.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements IAlunoService{

	@Autowired
	private AlunoRepository repository; //injeção de dependencia
	
	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = Aluno.builder() 
				.nome(form.getNome())
				.bairro(form.getBairro())
				.cpf(form.getCpf())
				.dataDeNascimento(form.getDataDeNascimento())
				.build();//forma diferente de criar um objeto sem precisar da um new e sem precisar ficar usando o metodo set, a n ser q queira utilizar.
		
		
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		
		return repository.getById(id);
	}

	@Override
	public List<Aluno> getAll() {
	
		return repository.findAll();// chama o metodo findAll do repository que esta extendendo da classe JpaRepository que ja faz a busca diretamente no banco
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = repository.getById(id);
		
		aluno.setNome(formUpdate.getNome());
		aluno.setBairro(formUpdate.getBairro());
		aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
		
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		 repository.deleteById(id);
		
	}

	
	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaAlunoId(Long id) {
		Aluno aluno = repository.findById(id).get(); //.get() é usado pq esse metodo findbyid pode lançar uma exception, 
		//o correto seria tratar ela, mas como estamos imaginando q o usuario e bonzinho e vai colocar um id real entao utilizamos o metodo get()
				
		return aluno.getAvaliacoes();
	}
	

	@Override
	public List<Aluno> getAllDataDeNascimento(String dataDeNascimento) { //consulta criada na mao, pq ela n existe dessa forma no JpaRepository.
		if(dataDeNascimento == null) {
			return repository.findAll();
		}else {
			LocalDate locadate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER); //conversão da string que chega em localDate, a clas JavaTimeUtils esta no pacote de infra e possui o formato de data brasileiro
			return repository.findByDataDeNascimento(locadate);
		}
		
	}

}
