package me.dio.academia.digital.entity.form;

import java.time.LocalDate;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

	
	@NotEmpty(message = "Preencha o campo corretamente") //essa anotation valida se o capo esta vazio, caso esteja ela lança essa mensagem, permitida apenas para Strings
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.") //define o tamanho da string
	private String nome;

	@NotEmpty(message = "Preencha o campo corretamente")
	//@CPF(message = "'${validatedValue}' é inválido") //valida se o cpf informado é um cpf valido, caso não seja lança essa msg
	private String cpf;

	@NotEmpty(message = "Preencha o campo corretamente")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;

	@NotNull(message = "Preencha o campo corretamente")
	@Past(message = "Data '${validatedValue}' é inválida")//anotation para validar se a data informada esta no passado.
	private LocalDate dataDeNascimento;
}
