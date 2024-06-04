package me.dio.academia.digital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	//JpaRepository classe que tem todos os metodos que iram acessar o banco de dados, o repository so precisa herda dela.
	
	
	//metodo para buscar uma lista de alunos de acordo com a data de nascimento deles.
	
	List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento); //consulta criada na mao, pq ela n existe dessa forma no JpaRepository
	//a forma de criar o nome do metodo deve seguir a msm logica das consultas do jparepository, 
	//como vou fazer uma busca eu uso o 'findBy' e o nome do atributo q vai fazer referencia na hora de buscar
	//como nesse caso eu vou buscar pelo atributo dataDeNascimento do aluno, entao o nome do metodo sera: findByDataDeNascimento.
	
	//seguindo essa logica o spring consegui fazer as buscar por debaixo dos panos.
}
