
import org.junit.Test;

import junit.framework.TestCase;

public class AlunoTest extends TestCase {

    // Disciplina
    Disciplina disciplina = new Disciplina("Matematica");

    // Trabalhos da disciplina
    Trabalho trab1 = new Trabalho("Trabalho 1", 10);
    Trabalho trab2 = new Trabalho("Trabalho 2", 10);
    Trabalho trab3 = new Trabalho("Trabalho 3", 10);

    // Alunos que estao matriculados em disciplina
    Aluno aluno1 = new Aluno("Joao", "18");
    Aluno aluno2 = new Aluno("Maria", "18");
    Aluno aluno3 = new Aluno("Jose", "18");

    @Test
    public void testMediaFinalRetornaZeroQuandoNaoTemNotas() {
        assertEquals(0, aluno1.mediaFinal());
    }

}