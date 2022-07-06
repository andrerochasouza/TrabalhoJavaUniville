package poo;

import java.util.ArrayList;

public class Disciplina {

	private String nome;
	private ArrayList<Trabalho> trabalhos;
	private ArrayList<Aluno> alunos;

	public Disciplina(String nome) {
		this.nome = nome;
		this.trabalhos = new ArrayList<>();
		this.alunos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addTrabalho(Trabalho trabalho) {
		for (Trabalho t : trabalhos) {
			if (t.equals(trabalho))
				throw new RuntimeException("Nome de Trabalho já existe");
		}
		this.trabalhos.add(trabalho);
	}

	public void deleteTrabalho(Trabalho trabalho) {
		try {
			this.trabalhos.remove(trabalho);
		} catch (RuntimeException e) {
			System.err.println("Não foi possivel de deletar o trabalho.." + e);
		}
	}

	public void addAluno(Aluno aluno) {
		for (Aluno a : alunos) {
			if (a.equals(aluno))
				throw new RuntimeException("Nome de Aluno já existe");
		}
		this.alunos.add(aluno);
	}

	public void deleteAluno(Aluno aluno) {
		try {
			this.alunos.remove(aluno);
		} catch (RuntimeException e) {
			System.err.println("Não foi possivel de deletar o Aluno.." + e);
		}
	}

	public void addNotaDeTrabalhoParaAluno(Aluno aluno, Trabalho trabalho, float nota) {
		if (existTrabalho(trabalho) && existAluno(aluno)) {
			aluno.addNota(nota, trabalho);
		} else {
			throw new RuntimeException("Não foi possivel adicionar a nota ao aluno");
		}
	}

	public Integer sizeTrabalhos() {
		return trabalhos.size();
	}

	public Integer sizeAlunos() {
		return alunos.size();
	}

	private boolean existAluno(Aluno aluno) {
		for (Aluno a : alunos) {
			if (a.equals(aluno)) {
				return true;
			}
		}
		throw new RuntimeException("Aluno nao encontrado");
	}

	private boolean existTrabalho(Trabalho trabalho) {
		for (Trabalho t : trabalhos) {
			if (t.equals(trabalho)) {
				return true;
			}
		}
		throw new RuntimeException("Trabalho nao encontrado");
	}
}
