package poo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AlunoTest {

	@Test
	public void testMediaFinalRetornaZeroQuandoNaoTemNotas() {
		assertEquals(0.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testMediaFinalRetorna10QuandoTodasAsNotasSao10DoAluno() {
		disciplina.addNotaDeTrabalhoParaAluno(aluno.getNome(), trab.getNome(), 10);

		assertEquals(10.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testMediaFinalRetorna7DoAluno() {
		disciplina.addNotaDeTrabalhoParaAluno(aluno.getNome(), trab.getNome(), 7);

		assertEquals(7.0F, aluno.mediaFinal(), 0.1F);
	}

	@Test
	public void testErroAoPegarUmaNotaDoAluno() {

		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.getNotaDeAluno(trab);
		});
	}

	@Test
	public void testErroAoDeletarUmaNotaDoAluno() {

		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.deleteNota(trab);
		});
	}

	@Test
	public void testErroAoAdicionarUmaNotaNegativaAoUmAluno() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			aluno.addNota(-1.0F, trab);
		});
	}

	private static Disciplina disciplina = new Disciplina("Matematica");
	private static Trabalho trab = new Trabalho("Trabalho 1", 10.0F);
	private static Aluno aluno = new Aluno("Joao", "18");

}