package org.alvarowau;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Creamos el objeto Scanner
        Scanner entrada = new Scanner(System.in);

        // Recogemos los operandos
        System.out.print("Digite el primer operando: ");
        double primerOperando = entrada.nextDouble();
        System.out.print("Digite el segundo operando: ");
        double segundoOperando = entrada.nextDouble();
        // cerramos el Scanner
        entrada.close();

        // Mostrar los resultados
        DecimalFormat df = new DecimalFormat("####.##");

        // Suma
        double resultado = primerOperando + segundoOperando;
        System.out.println("El resultado de la suma es: " + (df.format(resultado)));

        // Resta
        resultado = primerOperando - segundoOperando;
        System.out.println("El resultado de la resta es: " + (df.format(resultado)));

        // Multiplicación
        resultado = primerOperando * segundoOperando;
        System.out.println("El resultado de la multiplicación es: " + (df.format(resultado)));

        // División
        resultado = primerOperando / segundoOperando;
        System.out.println("El resultado de la división es: " + (df.format(resultado)));

        // Módulo
        resultado = primerOperando % segundoOperando;
        System.out.println("El resultado del módulo es: " + (df.format(resultado)));

    }
}

