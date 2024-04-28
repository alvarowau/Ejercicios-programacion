package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int factorial = -1; // Valor inicial negativo para entrar al bucle

        while (true) {
            System.out.print("Ingrese un número entero no negativo para calcular su factorial: ");
            String entradaTexto = entrada.nextLine();

            try {
                factorial = Integer.parseInt(entradaTexto);
                if (factorial >= 0) {
                    break; // Entrada válida, salir del bucle
                } else {
                    System.out.println("El número debe ser no negativo. Por favor, inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }

        long resultado = 1;
        for (int i = 1; i <= factorial; i++) {
            resultado *= i;
        }

        System.out.println("El factorial de " + factorial + " es: " + resultado);
        entrada.close();
    }
}
