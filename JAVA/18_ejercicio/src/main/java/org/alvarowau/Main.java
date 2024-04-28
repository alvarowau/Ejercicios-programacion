package org.alvarowau;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero = -1;
        int suma = 0;

        // Solicitar al usuario un número positivo
        do {
            System.out.print("Ingrese un número entero positivo: ");
            String entradaTexto = entrada.nextLine();
            try {
                numero = Integer.parseInt(entradaTexto);
                if (numero >= 0) {
                    break; // Salir del bucle si el número es positivo
                } else {
                    System.out.println("Por favor, ingrese un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
            }
        } while (true);

        // Lista para almacenar dígitos pares
        ArrayList<Integer> digitosPares = new ArrayList<>();

        // Extraer y sumar dígitos pares
        while (numero != 0) { // Mientras haya dígitos por extraer
            int ultimoDigito = numero % 10; // Obtener el último dígito
            if (ultimoDigito % 2 == 0) { // Verificar si es par
                digitosPares.add(ultimoDigito);
                suma += ultimoDigito;
            }
            numero /= 10; // Quitar el último dígito
        }

        if (digitosPares.isEmpty()) {
            System.out.println("No se encontraron dígitos pares.");
        } else {
            System.out.println("Los dígitos pares son: " + digitosPares +
                    "\nLa suma de los dígitos pares es: " + suma);
        }

        entrada.close();
    }
}
