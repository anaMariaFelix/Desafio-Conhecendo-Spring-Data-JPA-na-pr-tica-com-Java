package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "tb_avaliacao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AvaliacaoFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)//com o CascadeType.ALL tudo que for feito em avaliação vai ser refletido em aluno, mas existem outros tipos sem ser so o ALL
	@JoinColumn(name = "aluno_id")//usasse o joinColumn pq nessa entidade existe relacionamento com a entidade aluno e como o relacionamento nela é de manyToOne entao ela quem fica com a chave estrangeira
	private Aluno aluno;

	private LocalDateTime dataDaAvaliacao = LocalDateTime.now(); //a data esta sendo criada automaticamente

	@Column(name = "peso_atual")
	private double peso;

	@Column(name = "altura_atual")
	private double altura;

}
