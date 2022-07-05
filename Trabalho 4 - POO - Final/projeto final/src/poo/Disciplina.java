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
			if(t.equals(trabalho)) throw new RuntimeException("Nome de Trabalho já existe"); 
		}
		this.trabalhos.add(trabalho);				
	}

	public void deleteTrabalho(Trabalho trabalho) {
		try {
			this.trabalhos.remove(trabalho);			
		} catch (RuntimeException e) {
			System.err.println("Não foi possivel de deletar o trabalho.."+ e);
		}
	}

	public void addAluno(Aluno aluno) {
		for (Aluno a : alunos) {
			if(a.equals(aluno)) throw new RuntimeException("Nome de Aluno já existe"); 
		}
		this.alunos.add(aluno);
	}

	public void deleteAluno(Aluno aluno) {
		try {
			this.alunos.remove(aluno);			
		} catch (RuntimeException e) {
			System.err.println("Não foi possivel de deletar o Aluno.."+ e);
		}
	}

	public void addNotaDeTrabalhoParaAluno(String aluno, String trabalho, float nota) {
		try {
			Aluno a = getAlunoPorNome(aluno);
			Trabalho t = getTrabalhoPorNome(trabalho);
			
			a.addNota(nota, t);
		} catch (RuntimeException e) {
			System.err.println("Não foi possivel adicionar nota o(a) Aluno(a) "+ aluno + " no trabalho "+ trabalho);
			throw new RuntimeException();
		}
	}

	private Aluno getAlunoPorNome(String nome) {
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(nome)) {
				return aluno;
			}
		}
		throw new RuntimeException("Aluno nao encontrado");
	}
	
	private Trabalho getTrabalhoPorNome(String nome) {
		for (Trabalho trabalho : trabalhos) {
			if (trabalho.getNome().equals(nome)) {
				return trabalho;
			}
		}
		throw new RuntimeException("Trabalho nao encontrado");
	}

	public Integer sizeTrabalhos() {
		return trabalhos.size();
	}

	public Integer sizeAlunos() {
		return alunos.size();
	}

}
