package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el número de la tabla que desea conocer: ");
        int n = entrada.nextInt();
        entrada.close();

        System.out.println("Tabla de multiplicar del: " + n);
        System.out.println(n  + " * 1 = " + (n));
        System.out.println(n  + " * 2 = " + (n * 2));
        System.out.println(n  + " * 3 = " + (n * 3));
        System.out.println(n  + " * 4 = " + (n * 4));
        System.out.println(n  + " * 5 = " + (n * 5));
        System.out.println(n  + " * 6 = " + (n * 6));
        System.out.println(n  + " * 7 = " + (n * 7));
        System.out.println(n  + " * 8 = " + (n * 8));
        System.out.println(n  + " * 9 = " + (n * 9));
        System.out.println(n  + " * 10 = " + (n * 10));
    }
}
