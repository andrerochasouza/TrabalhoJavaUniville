package trabalho;

import java.util.Scanner;

public class Trabalho {

	/*
	 *	Autor: André da Rocha Souza
	 *	Email: andredarochasouza.12345@gmail.com
	 * 
	 * Opa professor, fiz esse trabalho com recursividade, pois estou lendo um livro
	 * sobre algoritmos, então só estou implementando junto com esse trabalho, se
	 * tiver algum problema e precisar usar loop, pode falar comigo que refaço o
	 * trabalho, valeu!!!
	 * 
	 * Nome do livro: Entendendo Algoritmos
	 * 
	 */

	static void rotacaoMatrizRecursivo(int matrizEntrada[][], int graus) {

		// Caso-base
		if (graus < 90) {
			System.out.println("Sua atual matriz é: ");
			System.out.println("");
			desenharMatrizNoConsole(matrizEntrada);
			System.out.println("");
			System.out.println("==============================");

			// Caso-Recursivo
		} else {
			rotacaoMatrizRecursivo(rotacaoMatrizNoventaGrausPar(matrizEntrada), graus - 90);
		}
	}

	static void desenharMatrizNoConsole(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("[" + matriz[i][j] + "]");
			}
			System.out.println("");
		}

	}

	static int[][] iterandoMatrizAutomatico(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = j;
			}
		}

		return matriz;
	}

	static int[][] iterandoMatrizManual(int matriz[][]) {
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.println("Coluna: " + (i + 1) + " || Linha: " + (j + 1));
				System.out.println("Digite o valor: ");
				matriz[i][j] = scanner.nextInt();
			}
		}

		scanner.close();
		return matriz;
	}

	static int[][] rotacaoMatrizNoventaGrausPar(int antigoMatriz[][]) {

		int novaMatriz[][] = new int[antigoMatriz.length][antigoMatriz.length];
		
		for (int i = 0; i < antigoMatriz.length; i++) {
			for (int j = 0; j < antigoMatriz[i].length; j++) {
				novaMatriz[j][(antigoMatriz.length-1)-i] = antigoMatriz[i][j];				
			}
		}

		return novaMatriz;
	}
	

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int tamanho = 1;
		int rotacao = 0;

		try {
			System.out.print("Qual o tamanho do quadrado da matriz você quer ter?");
			tamanho = scanner.nextInt();

			System.out.print("Qual o valor da rotacao: (só pode 0, 90, 180, 270 ou 360)");
			rotacao = scanner.nextInt();

			if (rotacao < 0 || rotacao > 360 || tamanho < 1) {
				scanner.close();
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Você digitou qualquer outro caracter ou digitou um número fora do escopo");
			throw new Exception(e);
		}

		int matriz[][] = new int[tamanho][tamanho];
		
		System.out.println("Quer colocar valores manualmente na matriz? (0 - Não | 1 - Sim)");
		int valoresMatriz = scanner.nextInt();
		if (valoresMatriz == 0) {
			matriz = iterandoMatrizAutomatico(matriz);
		} else {
			matriz = iterandoMatrizManual(matriz);
		}

		System.out.println("");
		System.out.println("==============================");
		System.out.println("Sua antiga matriz era: ");
		System.out.println("");
		desenharMatrizNoConsole(matriz);
		System.out.println("");
		System.out.println("==============================");
		rotacaoMatrizRecursivo(matriz, rotacao);

		scanner.close();
	}

}
