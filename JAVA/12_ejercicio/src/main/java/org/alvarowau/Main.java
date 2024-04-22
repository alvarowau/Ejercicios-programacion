package org.alvarowau;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Inicialización del generador de números aleatorios
        Random rd = new Random();
        // Genera un número aleatorio entre 0 y 100 (inclusive)
        int numeroGenerado = rd.nextInt(101);
        // Contador de intentos del jugador
        int contador = 0;
        // Variable para almacenar el número ingresado por el jugador
        int numeroJugador;

        System.out.println("Bienvenido al juego de adivina el número");

        // Bucle do-while que permite al jugador adivinar el número hasta que se agoten los intentos o acierte
        do {
            contador++; // Incrementa el contador de intentos
            System.out.print("Digite el número: ");
            numeroJugador = entrada.nextInt();

            // Comprueba si el número ingresado es igual al número generado aleatoriamente
            if (numeroJugador == numeroGenerado) {
                System.out.println("¡Has acertado el número generado!"); // Mensaje de acierto
                System.out.println("Lo has hecho en " + contador + " intentos"); // Muestra la cantidad de intentos
                break; // Sale del bucle
            }

            // Si el número ingresado es mayor que el número generado, muestra un mensaje indicando que es menor
            if (numeroJugador > numeroGenerado) System.out.println("El número es menor\n");
                // Si el número ingresado es menor que el número generado, muestra un mensaje indicando que es mayor
            else System.out.println("El número es mayor\n");

            // Muestra la cantidad de intentos restantes
            System.out.println("Te quedan " + (10 - contador) + " intentos\n");
        } while (contador != 10); // Continúa el bucle mientras el contador no alcance 10 intentos

        // Si el jugador ha agotado todos los intentos, muestra un mensaje indicando que debe volver a empezar
        if (contador == 10) System.out.println("Has consumido todos los intentos, vuelve a empezar otra partida");
            // Si el jugador ha acertado antes de agotar los intentos, muestra un mensaje de felicitación
        else System.out.println("¡Lo conseguiste, eres un genio! Vuelve a empezar otra partida");
    }
}
