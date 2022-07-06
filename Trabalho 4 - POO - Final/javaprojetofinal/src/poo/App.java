package poo;

public class App {
    public static void main(String[] args) throws Exception {

        // dados
        Disciplina disciplina = new Disciplina("Java");

        Aluno aluno1 = new Aluno("João", "18");
        Aluno aluno2 = new Aluno("Maria", "19");
        Aluno aluno3 = new Aluno("Pedro", "20");
        Aluno aluno4 = new Aluno("José", "21");

        Trabalho trabalho1 = new Trabalho("Prova 1", 2.5f);
        Trabalho trabalho2 = new Trabalho("Prova 2", 2.5f);
        Trabalho trabalho3 = new Trabalho("Prova 3", 2.5f);
        Trabalho trabalho4 = new Trabalho("Prova 4", 2.5f);

        // Adicionando alunos e trabalhos a disciplina
        disciplina.addAluno(aluno1);
        disciplina.addAluno(aluno2);
        disciplina.addAluno(aluno3);
        disciplina.addAluno(aluno4);
        disciplina.addTrabalho(trabalho1);
        disciplina.addTrabalho(trabalho2);
        disciplina.addTrabalho(trabalho3);
        disciplina.addTrabalho(trabalho4);

        // Adicionando algumas notas aos alunos

        // Aluno 1
        disciplina.addNotaDeTrabalhoParaAluno(aluno1, trabalho1, 2.1f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno1, trabalho2, 1.3f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno1, trabalho3, 2.5f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno1, trabalho4, 0.2f);

        // Aluno 2
        disciplina.addNotaDeTrabalhoParaAluno(aluno2, trabalho1, 0.2f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno2, trabalho2, 0.5f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno2, trabalho3, 1.9f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno2, trabalho4, 2.5f);

        // Aluno 3
        disciplina.addNotaDeTrabalhoParaAluno(aluno3, trabalho1, 2.3f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno3, trabalho2, 2.3f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno3, trabalho3, 2.3f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno3, trabalho4, 2.3f);

        // Aluno 4
        disciplina.addNotaDeTrabalhoParaAluno(aluno4, trabalho1, 2.4f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno4, trabalho2, 2.4f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno4, trabalho3, 2.4f);
        disciplina.addNotaDeTrabalhoParaAluno(aluno4, trabalho4, 2.4f);

        // Imprimindo as medias dos 4 alunos
        System.out.println(aluno1.getNome() + ": " + aluno1.mediaFinal());
        System.out.println(aluno2.getNome() + ": " + aluno2.mediaFinal());
        System.out.println(aluno3.getNome() + ": " + aluno3.mediaFinal());
        System.out.println(aluno4.getNome() + ": " + aluno4.mediaFinal());
    }
}
