package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        long primer = 0; // Inicializa el primer número de la serie Fibonacci
        long segundo = 1; // Inicializa el segundo número de la serie Fibonacci
        long auxiliar = 0; // Variable auxiliar para calcular los siguientes números de la serie

        // Solicita al usuario la cantidad de números Fibonacci que desea ver
        System.out.print("Digite los números Fibonacci que quiere ver: ");
        int cantidad = entrada.nextInt();
        entrada.close();
        StringBuilder solucion = new StringBuilder(); // StringBuilder para construir la solución

        // Caso base: si el usuario quiere ver solo el primer número Fibonacci
        if (cantidad == 1) {
            solucion.append(primer);
        }
        // Caso base: si el usuario quiere ver los dos primeros números Fibonacci
        else if (cantidad == 2) {
            solucion.append(primer).append(", ").append(segundo);
        }
        // Si el usuario quiere ver más de dos números Fibonacci
        else if (cantidad >= 3) {
            solucion.append(primer).append(", ").append(segundo); // Agrega los dos primeros números a la solución
            // Calcula y agrega los siguientes números Fibonacci a la solución
            for (int i = 2; i < cantidad; i++) {
                auxiliar = primer + segundo;
                solucion.append(", ").append(auxiliar);
                primer = segundo;
                segundo = auxiliar;
            }
        }
        // Si la cantidad ingresada es menor que 1, se sale del programa
        else {
            System.out.println("¡No se puede hacer nada!");
            System.exit(0);
        }

        solucion.append("."); // Agrega un punto al final de la solución
        System.out.println(solucion);
    }
}
