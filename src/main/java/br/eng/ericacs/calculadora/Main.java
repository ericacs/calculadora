package br.eng.ericacs.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Calculadora!");
        System.out.println("Digite 'sair' para encerrar o programa.");

        while (true) {
            System.out.println("\nEscolha uma operação: + - * /");
            System.out.print("Operação: ");
            String operacao = scanner.nextLine();

            if (operacao.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando a calculadora. Até logo!");
                break;
            }

            try {
                System.out.print("Digite o primeiro número: ");
                double a = Double.parseDouble(scanner.nextLine());

                System.out.print("Digite o segundo número: ");
                double b = Double.parseDouble(scanner.nextLine());

                double resultado = switch (operacao) {
                    case "+" -> calc.somar(a, b);
                    case "-" -> calc.subtrair(a, b);
                    case "*" -> calc.multiplicar(a, b);
                    case "/" -> calc.dividir(a, b);
                    default -> {
                        System.out.println("Operação inválida.");
                        yield Double.NaN;
                    }
                };

                if (!Double.isNaN(resultado)) {
                    System.out.println("Resultado: " + resultado);
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite apenas números.");
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}