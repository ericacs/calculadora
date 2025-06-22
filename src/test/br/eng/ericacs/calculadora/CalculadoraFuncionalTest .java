package br.eng.ericacs.calculadora;


import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculadoraFuncionalTest {

    @Test
    void deveExecutarSomaComSucesso() throws Exception {
        // Simula entrada do usuário: operação +, número 5, número 3, sair
        String input = "+\n5\n3\nsair\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Captura a saída do console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Executa o programa principal
        Main.main(new String[]{});

        String output = outContent.toString();

        // Verifica se o resultado correto está na saída
        assertTrue(output.contains("Resultado: 8.0"));
    }

    @Test
    void deveRetornarErroAoDividirPorZero() throws Exception {
        String input = "/\n10\n0\nsair\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Erro: Divisão por zero"));
    }

    @Test
    void deveInformarOperacaoInvalida() throws Exception {
        String input = "x\n4\n2\nsair\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Operação inválida"));
    }
}