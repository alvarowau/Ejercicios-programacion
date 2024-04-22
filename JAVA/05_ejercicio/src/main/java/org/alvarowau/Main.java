package org.alvarowau;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite la primera nota: ");
        float primera = entrada.nextFloat();
        System.out.print("Digite la segunda nota: ");
        float segunda = entrada.nextFloat();
        System.out.print("Digite la tercera nota: ");
        float tercera = entrada.nextFloat();
        entrada.close();

        float resultado = (primera + segunda + tercera) / 3;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("La nota media es: " + df.format(resultado));
        if(resultado >= 5){
            System.out.println("El alumno está aprobado");
        }else{
            System.out.println("El alumno no está aprobado");
        }

    }
}
