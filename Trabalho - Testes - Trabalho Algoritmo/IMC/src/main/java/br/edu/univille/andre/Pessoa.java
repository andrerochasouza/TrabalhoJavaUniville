package br.edu.univille.andre;

public class Pessoa {

    private String nome;
    private int peso;
    private double altura;

    public Pessoa() {  }


    // Getters e Setters de nome, peso e altura

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
            this.nome = nome;
        } catch (Exception e){
            System.out.println("Erro ao digitar o nome");
            e.printStackTrace();
        }
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        try{
            this.peso = peso;
        } catch(Exception e){
            System.out.println("Erro ao digitar o peso");
            e.printStackTrace();
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        try {
            this.altura = altura;
        } catch(Exception e){
            System.out.println("Erro ao digitar a altura");
            e.printStackTrace();
        }
    }
}
