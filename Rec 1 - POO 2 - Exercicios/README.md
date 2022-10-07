# Exercicio Prova de POO

1. Crie um código que apresente uma herança.

![Herança](https://github.com/andrerochasouza/TrabalhoJavaUniville/blob/main/Rec%201%20-%20POO%202%20-%20Exercicios/heranca.png)

```java

public class Linha {
    private int x1, x2, y1, y2;

    public Linha(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    // Getters, Setters e toString
}

public class Retangulo extends Linha {
    private int largura, altura;

    public Retangulo(int x1, int x2, int y1, int y2, int largura, int altura) {
        super(x1, x2, y1, y2);
        this.largura = largura;
        this.altura = altura;
    }

    // Getters, Setters e toString
}


public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(1, 2, 3, 4, 5, 6);
        System.out.println(retangulo);
    }
}
```

2. Crie um código que apresente uma implementação de interface.

![Interface](https://github.com/andrerochasouza/TrabalhoJavaUniville/blob/main/Rec%201%20-%20POO%202%20-%20Exercicios/interface.jpg)

```java

public interface IFormaGeometrica {
    public double calcularArea();
}

public class Quadrado implements IFormaGeometrica {
   
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    // Getters, Setters e toString
}

public class Main {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(5);
        System.out.println(quadrado.calcularArea());
    }
}
``` 

3. Crie um código que apresente uma sobrecarga de método.

![Sobrecarga](https://github.com/andrerochasouza/TrabalhoJavaUniville/blob/main/Rec%201%20-%20POO%202%20-%20Exercicios/sobrecarga.jpg)


```java

public class Calculadora {
    public int somar(int... numeros) {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public double somar(double... numeros) {
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.somar(1, 2, 3, 4, 5));
        System.out.println(calculadora.somar(1.0, 2.0, 3.0, 4.0, 5.0));
    }
}
``` 

4. Crie um código que apresente uma relação de composição.

![Composição](https://github.com/andrerochasouza/TrabalhoJavaUniville/blob/main/Rec%201%20-%20POO%202%20-%20Exercicios/composicao.jpg)

```java

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters, Setters e toString
}

public class Carro {
    private String modelo;
    private Pessoa dono;

    public Carro(String modelo, Pessoa dono) {
        this.modelo = modelo;
        this.dono = dono;
    }

    // Getters, Setters e toString
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 20);
        Carro carro = new Carro("Fusca", pessoa);
        System.out.println(carro);
    }
}
```
