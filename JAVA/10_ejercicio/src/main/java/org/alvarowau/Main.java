package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite el número del cual quiera averiguar la tabla de multiplicar: ");
        int numero = entrada.nextInt();
        entrada.close();
        String cadena = "";
        System.out.println("La tabla de multiplicar de "+ numero + " es: ");
        for (int i = 1; i <= 10; i++) {
            cadena += numero + " * "+ i + " = " + (numero * i) + "\n";
        }
        System.out.print(cadena);
    }
}
