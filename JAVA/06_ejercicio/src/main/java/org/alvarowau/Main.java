package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite el número que quiera comprobar: ");

        int numero = entrada.nextInt();

        entrada.close();
        String cadena = "";
        if(numero % 2 == 0) cadena += "El número es divisible entre dos. ";
        if(numero % 5 == 0) cadena += "El número es divisible entre cinco. ";
        if(cadena.isEmpty()) cadena += "El número no es divisible ni entre dos ni entre cinco.";
        System.out.println(cadena);
    }
}
