package org.alvarowau;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite el radio del círculo:");
        double radio = entrada.nextDouble();
        entrada.close();
        DecimalFormat df = new DecimalFormat("####.##");
        double resultado = (Math.PI * radio * radio);
        System.out.println("El área del círculo es: " + df.format(resultado));
    }
}
