package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Solicitar al usuario que ingrese la altura y la base del polígono
        System.out.print("Ingrese la altura del polígono: ");
        int altura = entrada.nextInt();
        System.out.print("Ingrese la base del polígono: ");
        int base = entrada.nextInt();

        // Dibujar polígono con interior blanco
        System.out.println("Polígono con interior blanco:");
        for (int i = 1; i <= altura; i++) { // Iterar sobre las filas del polígono
            for (int j = 1; j <= base; j++) { // Iterar sobre las columnas del polígono
                // Verificar si estamos en el borde del polígono o en el interior
                if (i == 1 || i == altura || j == 1 || j == base) {
                    System.out.print("*"); // Imprimir asterisco si es el borde
                } else {
                    System.out.print(" "); // Imprimir espacio en blanco si es el interior
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

        // Dibujar polígono lleno
        System.out.println("Polígono lleno:");
        for (int i = 1; i <= altura; i++) { // Iterar sobre las filas del polígono
            for (int j = 1; j <= base; j++) { // Iterar sobre las columnas del polígono
                System.out.print("*"); // Imprimir asterisco en cada posición
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

        entrada.close(); // Cerrar el scanner
    }
}
