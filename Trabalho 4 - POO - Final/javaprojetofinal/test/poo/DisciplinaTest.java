import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import poo.Aluno;
import poo.Disciplina;
import poo.Trabalho;

public class DisciplinaTest {

	@Test
	public void testDeletarUmTrabalho() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);

		disciplina.deleteTrabalho(trab);

		assertEquals(0, disciplina.sizeTrabalhos());
	}

	@Test
	public void testAdicionarUmTrabalho() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);

		disciplina.addTrabalho(trab);

		assertEquals(1, disciplina.sizeTrabalhos());
	}

	@Test
	public void testDeletarUmAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Aluno aluno = new Aluno("Maria", "18");

		disciplina.addAluno(aluno);
		disciplina.deleteAluno(aluno);

		assertEquals(0, disciplina.sizeAlunos());
	}

	@Test
	public void testAdicionarUmAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Aluno aluno = new Aluno("Maria", "18");

		disciplina.addAluno(aluno);

		assertEquals(1, disciplina.sizeAlunos());
	}

	@Test
	public void testAdicionarANota10AUmAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0f);
		Aluno aluno = new Aluno("Maria", "18");

		disciplina.addTrabalho(trab);
		disciplina.addAluno(aluno);

		disciplina.addNotaDeTrabalhoParaAluno(aluno, trab, 10.0f);

		assertEquals(10.0f, aluno.mediaFinal(), 0.1f);
	}

	@Test
	public void testRetornarErroQuandoAdicionarNotaNegativa() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		Assertions.assertThrows(RuntimeException.class, () -> {
			disciplina.addNotaDeTrabalhoParaAluno(aluno, trab, -1.0f);
		});
	}

	@Test
	public void testRetornarErroQuandoAdicionaNotaENaoTemAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0f);
		Aluno aluno = new Aluno("Maria", "18");

		Assertions.assertThrows(RuntimeException.class, () -> {
			disciplina.addNotaDeTrabalhoParaAluno(aluno, trab, 10f);
		});
	}

}
