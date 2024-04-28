package org.alvarowau;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String palo = eligePalo(); // Elegir un palo al azar
        String numero = eligeNumero(); // Elegir un número al azar
        System.out.println("La carta es: " + numero + " de " + palo); // Mostrar la carta seleccionada
    }

    private static String eligePalo() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        int indice = random.nextInt(palos.length); // Elegir un índice al azar
        return palos[indice]; // Devolver el palo correspondiente
    }

    private static String eligeNumero() {
        String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int indice = random.nextInt(numeros.length); // Elegir un índice al azar
        return numeros[indice]; // Devolver el número correspondiente
    }
}
