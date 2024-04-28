package org.alvarowau;


import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Selecciones un numero entre 0 y 99999");
        int numero = entrada.nextInt();
        if(numero < 0 || numero > 99999) {
            System.out.println("Numero invalido");
        }
        int numeroRandGanador ;
        String numeroElegido;
        String numeroGanador;
        double premioAcumulado;
        int serieRandon;
        String serie;
        do{
            numeroRandGanador = rand.nextInt(99999) + 1;
            numeroGanador = addCeros(numeroRandGanador,5);
            numeroElegido = addCeros(numero,5);

        }while(true);
    }

    private static String addCeros(int numero, int cifras){
        String ceros;
        if(cifras == 3) ceros = "000";
        else ceros = "00000";
        DecimalFormat formato = new DecimalFormat(ceros);
        String numeroFormateado = formato.format(numero);
        return numeroFormateado;
    }
}