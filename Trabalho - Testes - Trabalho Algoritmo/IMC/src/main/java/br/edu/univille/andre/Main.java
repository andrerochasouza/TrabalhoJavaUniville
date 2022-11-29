package br.edu.univille.andre;

import java.util.Locale;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner scanner = new Scanner(System.in);

            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Cleber");
            pessoa.setPeso(80);
            pessoa.setAltura(1.80);

            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Peso: " + pessoa.getPeso());
            System.out.println("Altura: " + pessoa.getAltura());

            double imc = IMC.calcularIMC(pessoa);
            System.out.println("IMC: " + imc);

            String classificacao = IMC.classificarIMC(pessoa);
            System.out.println("Classificação: " + classificacao);

            scanner.close();

        }
}