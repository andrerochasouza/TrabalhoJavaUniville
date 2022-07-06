import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import poo.Aluno;
import poo.Disciplina;
import poo.Trabalho;

public class AlunoTest {

	@Test
	public void testMediaFinalRetornaZeroQuandoNaoTemNotas() {
		Aluno aluno = new Aluno("Maria", "18");

		assertEquals(0.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testMediaFinalRetorna10QuandoTodasAsNotasSao10DoAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		aluno.addNota(10.0F, trab);

		assertEquals(10.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testMediaFinalRetorna7DoAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		disciplina.addAluno(aluno);
		disciplina.addTrabalho(trab);
		disciplina.addNotaDeTrabalhoParaAluno(aluno, trab, 7.0F);

		assertEquals(7.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testErroAoPegarUmaNotaDoAluno() {
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.getNotaDeAluno(trab);
		});
	}

	@Test
	public void testErroAoDeletarUmaNotaDoAluno() {
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.deleteNota(trab);
		});
	}

	@Test
	public void testErroAoAdicionarUmaNotaNegativaAoUmAluno() {
		Disciplina disciplina = new Disciplina("Matematica");
		Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
		Aluno aluno = new Aluno("Maria", "18");

		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.addNota(-1.0F, trab);
		});
	}
}