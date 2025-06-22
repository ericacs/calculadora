package br.eng.ericacs.calculadora;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    void testSoma() {
        assertEquals(5, calc.somar(2, 3));
    }

    @Test
    void testSubtracao() {
        assertEquals(1, calc.subtrair(4, 3));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(12, calc.multiplicar(3, 4));
    }

    @Test
    void testDivisao() {
        assertEquals(2.5, calc.dividir(5, 2));
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(1, 0));
    }
}