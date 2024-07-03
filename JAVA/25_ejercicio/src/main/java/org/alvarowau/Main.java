package org.alvarowau;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static int cantidad = 0; // Total height of the container
    private static int agua = 0; // Water level
    private static int ancho = 0; // Width of the container
    private static Random r = new Random();

    public static void main(String[] args) {
        pedirNumeros();
        pintarCubo();
    }

    // Method to print the container and water
    private static void pintarCubo() {
        for (int i = cantidad; i >= 0; i--) {
            for (int j = 0; j <= ancho; j++) {
                if (i == 0) { // Bottom of the container
                    System.out.print("*");
                } else {
                    if (j == 0 || j == ancho) { // Sides of the container
                        System.out.print("*");
                    } else {
                        if (i <= agua) { // Water inside the container
                            System.out.print("=");
                        } else {
                            System.out.print(" "); // Empty space inside the container
                        }
                    }
                }
            }
            System.out.println(); // New line after each row
        }
    }

    // Method to get user input and set up the container dimensions
    private static void pedirNumeros() {
        do {
            try {
                System.out.print("Digite el nivel de agua que desea en el barril (>0): ");
                agua = entrada.nextInt();
                if (agua <= 0) {
                    System.out.println("Por favor, introduzca un número válido mayor que 0.");
                    agua = 0;
                }
            } catch (Exception e) {
                System.out.println("Por favor, introduzca un número válido mayor que 0.");
                entrada.next(); // Clear the invalid input
                agua = 0;
            }
        } while (agua == 0);

        cantidad = agua + r.nextInt(1, 10); // Ensure the container height is at least the water level plus some random
                                            // height
        ancho = r.nextInt(3, 11); // Random width between 3 and 10
    }
}
