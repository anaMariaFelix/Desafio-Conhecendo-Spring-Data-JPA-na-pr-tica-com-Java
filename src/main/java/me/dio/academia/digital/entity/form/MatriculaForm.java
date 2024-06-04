package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {

	
	@NotNull(message = "Preencha o campo corretamente")//notNull suporta o long, ja o notblanck so suporta string
	@Positive(message = "O Id do aluno precisa ser positivo") //essa anotation e usada quando queremos apenas numeros positivos, caso seja informado um negativo ela ira lançar a mensagem
	private Long alunoId;

}
