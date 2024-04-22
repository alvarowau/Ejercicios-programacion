package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite el número que quieras sacar la primera cifra y última (máximo 5 cifras): ");
        int n = entrada.nextInt();
        entrada.close();

        // Lo que hace el %10: cualquier número dividido entre 10, el resto es su última cifra

        if (n < 10)
            System.out.println("La primera cifra es: " + n);
        else if (n < 100)
            System.out.println("La primera cifra es: " + (n / 10) % 10);
        else if (n < 1000)
            System.out.println("La primera cifra es: " + (n / 100) % 10);
        else if (n < 10000)
            System.out.println("La primera cifra es: " + (n / 1000) % 10);
        else if (n < 100000)
            System.out.println("La primera cifra es: " + (n / 10000) % 10);
        else
            System.out.println("Pusiste demasiadas cifras");

        System.out.println("La última cifra del número es: " + n % 10);
    }
}
