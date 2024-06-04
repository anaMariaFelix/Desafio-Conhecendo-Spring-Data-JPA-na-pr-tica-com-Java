package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.dio.academia.digital.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	List<Matricula> findByAlunoBairro(String bairro);
	//a forma de criar o nome do metodo deve seguir a msm logica das consultas do jparepository, 
		//como vou fazer uma busca eu uso o 'findBy' e o nome do atributo q vai fazer referencia na hora de buscar
		//como nesse caso eu vou buscar pelo atributo dataDeNascimento do aluno, entao o nome do metodo sera: findByAlunoBairro.
		
		//seguindo essa logica o spring consegui fazer as buscar por debaixo dos panos.
	
	
	
	
	//duas formas diferentes de fazer essa mesma consulta.
	//existem outras formas fora essas
	
	
	//outra forma de fazer a msm colsulta no banco so que agora usando a anotation @query e passando o sql
	//nessa forma o nome do metodo n precisa seguir a logica que sitei antes.
	//a implementação nas outras classes é feita do mesmo jeito que da outra forma
	@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro")
	List<Matricula> findAlunoBairro(String bairro);
	
	
	//SQL native
	@Query(value = "SELECT * FROM tb_matriculas m" +
			"INNER JOIN tb_alunos a ON m.alunos_id = a.id"+
			"WHERE a.bairro = :bairro", nativeQuery = true)
	List<Matricula> findAlunoPorBairro(String bairro);
}
