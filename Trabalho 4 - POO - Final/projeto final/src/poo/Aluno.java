package poo;

import java.util.HashMap;

public class Aluno {

	private String nome;
	private String idade;
	private HashMap<Trabalho, Float> notas;

	public Aluno(String nome, String idade) {
		this.nome = nome;
		this.idade = idade;
		this.notas = new HashMap<Trabalho, Float>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public float mediaFinal() {
		float notasVezesPesos = 0.0F;
		float somaPesos = 0.0F;
		
		if(notas.isEmpty()) {
			return 0.0F;
		}
		
		for (Trabalho trabalho : notas.keySet()) {
			notasVezesPesos += notas.get(trabalho) * trabalho.getPeso();
			somaPesos += trabalho.getPeso();
		}

		return notasVezesPesos / somaPesos;
	}

	public void addNota(float nota, Trabalho trabalho) {
		if (nota > 0.0F && nota <= trabalho.getPeso() && notas.get(trabalho) == null) {
			notas.put(trabalho, nota);
		}
		throw new RuntimeException("Erro ao adicionar uma nota ao trabalho");
	}

	public void deleteNota(Trabalho trabalho) {
		if (notas.get(trabalho) != null) {
			notas.remove(trabalho);
		}
		throw new RuntimeException("Erro ao apagar a nota do trabalho");
	}

	public float getNotaDeAluno(Trabalho trabalho) {
		if (notas.get(trabalho) != null) {
			return notas.get(trabalho);
		}
		throw new RuntimeException("Erro ao pegar a nota do trabalho");
	}
}
