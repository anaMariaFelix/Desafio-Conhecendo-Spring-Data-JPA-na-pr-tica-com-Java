package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder //para facilitar na hora de estanciar um objeto e trabaalhar com seus atributos
@Data
@NoArgsConstructor //cria um constructor vazio, se n criar o hibernate da erro
@AllArgsConstructor //outro constructor que contem todos os atributos da classe
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //annotation para ignorar as possiveis exception que o lazy que pode lançar 
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true)//unique = true significa q o cpf n pode ser repetido, ou seja outra pessoa n pode ter o msm cpf que outra
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;
	
	@OneToOne(mappedBy = "aluno",  fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JsonIgnore
	private Matricula amatricula;

	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY , cascade = CascadeType.ALL)//mappedBy = "aluno" significa que na outra entidade AvaliacaoFisica o atributo aluno tbm esta sendo mapeado
	@JsonIgnore //annotation para ignorar as possiveis exception que o lazy que pode lançar 
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

  
}
