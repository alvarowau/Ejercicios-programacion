package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int numero = entrada.nextInt();
        int numeroAbsoluto = Math.abs(numero);
        int numeroInvertido = 0;

        int cantidadDigitos = (int) (Math.log10(numeroAbsoluto) + 1);

        if (cantidadDigitos > 1) {
            // Invertir los dígitos del número
            while (numeroAbsoluto > 0) {
                int ultimoDigito = numeroAbsoluto % 10; // Obtener el último dígito
                numeroInvertido = numeroInvertido * 10 + ultimoDigito; // Construir el número invertido
                numeroAbsoluto /= 10; // Eliminar el último dígito
            }

            System.out.println(); // Salto de línea

            // Comparar el número invertido con el número absoluto
            if (numeroInvertido == Math.abs(numero)) {
                System.out.println("El número es capicúa.");
            } else {
                System.out.println("El número no es capicúa.");
            }
        } else {
            System.out.println("El número no tiene suficientes cifras para ser capicúa.");
        }

        entrada.close();
    }
}
