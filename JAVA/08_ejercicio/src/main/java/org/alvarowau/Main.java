package org.alvarowau;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioEntrada = 8;
        double precioTotalEntradas;
        boolean tarjeta = false;

        System.out.print("Digite el número de entradas: ");
        int entradas = sc.nextInt();

        System.out.println("Digite el día de la semana:");
        System.out.println("l. Lunes");
        System.out.println("m. Martes");
        System.out.println("x. Miércoles");
        System.out.println("j. Jueves");
        System.out.println("v. Viernes");
        System.out.println("s. Sábado");
        System.out.println("d. Domingo");
        String dia = sc.next();

        System.out.print("¿Tiene la tarjeta del cine? 'n. NO s. SI': ");
        String tiene = sc.next();

        switch (tiene) {
            case "n":
                tarjeta = false;
                break;
            case "s":
                tarjeta = true;
                break;
            default:
                tarjeta = false;
        }
        sc.close();

        switch (dia) {
            case "x":
                precioEntrada = 5;
                precioTotalEntradas = precioEntrada * entradas;
                break;
            case "j":
                int aux = entradas % 2;
                entradas /= 2;
                precioTotalEntradas = (entradas * 11) + (aux * precioEntrada);
                break;
            default:
                precioTotalEntradas = precioEntrada * entradas;
        }
        if(tarjeta) {
            precioTotalEntradas -= (precioTotalEntradas * 0.10);
        }

        System.out.println("El precio total de las entradas es: " + precioTotalEntradas);
    }
}
