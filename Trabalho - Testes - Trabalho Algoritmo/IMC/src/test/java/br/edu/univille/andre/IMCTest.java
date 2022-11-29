package br.edu.univille.andre;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMCTest {

    @Test
    public void testCalcularIMC() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Andre");
        pessoa.setPeso(80);
        pessoa.setAltura(1.80);
        double imc = IMC.calcularIMC(pessoa);
        assertEquals(24.69, imc);
    }

    @Test
    public void testClassificarIMC() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Andre");
        pessoa.setPeso(80);
        pessoa.setAltura(1.80);
        String classificacao = IMC.classificarIMC(pessoa);
        assertEquals("A pessoa Andre tem o IMC de 24.69 e está Peso normal", classificacao);
    }

    @Test
    public void testeErroSemPontoNoValorDaAltura(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Andre");
        pessoa.setPeso(80);
        pessoa.setAltura(180);
        String classificacao = IMC.classificarIMC(pessoa);
        Assertions.assertNotEquals("A pessoa Andre tem o IMC de 24.69 e está Peso normal", classificacao);
    }

}
