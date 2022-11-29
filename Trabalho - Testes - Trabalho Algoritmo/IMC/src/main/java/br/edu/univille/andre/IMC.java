package br.edu.univille.andre;

public class IMC {
    public static double calcularIMC(Pessoa pessoa) {
        double imc = pessoa.getPeso() / (pessoa.getAltura() * pessoa.getAltura());
        double roundIMC = Math.round(imc * 100.0) / 100.0;

        return roundIMC;
    }

    public static String classificarIMC(double imc) {
        String classificacao = "";

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            classificacao = "Peso normal";
        } else if (imc >= 25 && imc <= 29.9) {
            classificacao = "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            classificacao = "Obesidade grau 1";
        } else if (imc >= 35 && imc <= 39.9) {
            classificacao = "Obesidade grau 2";
        } else if (imc >= 40) {
            classificacao = "Obesidade grau 3";
        }

        return classificacao;
    }

    public static String classificarIMC(Pessoa pessoa) {
        double imc = calcularIMC(pessoa);
        return "A pessoa " + pessoa.getNome() + " tem o IMC de " + imc + " e está " + classificarIMC(imc);
    }
}
