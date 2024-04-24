package org.alvarowau;

import java.util.Scanner; // Importamos la clase Scanner para la entrada de datos

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);


        System.out.print("Digite el número que quiere invertir: ");
        int numero = entrada.nextInt(); // Leer el número ingresado por el usuario

        // Variable para almacenar el número invertido
        int invertido = 0;

        // Bucle para invertir el número
        do {
            // Tomar el último dígito del número actual y añadirlo al invertido
            invertido = invertido * 10 + (numero % 10);

            // Eliminar el último dígito del número original
            numero /= 10;
        } while (numero > 0); // Continuar hasta que no queden más dígitos


        entrada.close();

        // Mostrar el resultado del número invertido
        System.out.println("El número invertido es: " + invertido);
    }
}
