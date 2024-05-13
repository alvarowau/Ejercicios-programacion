package org.alvarowau;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int suma = 0;
        int contador = 0;

        // Mensaje de instrucciones para el usuario
        System.out.println("Ingrese los números que desee. Ingrese una letra para terminar.");
        do {
            try {
                System.out.print("Ingrese un número (Ingrese una letra para terminar.): ");
                int numero = entrada.nextInt();
                if (numero >= 0) {
                    suma += numero;
                    contador++;
                }
            } catch (InputMismatchException e) {
                break;
            }
        } while (true);
        if (contador != 0) {
            System.out.println("La media es: " + (double) suma / contador);
        } else {
            System.out.println("No se ha podido hallar la media.");
        }
        entrada.close();
    }
}
