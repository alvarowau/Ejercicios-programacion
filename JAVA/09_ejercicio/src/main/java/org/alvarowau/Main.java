package org.alvarowau;

import java.util.Random;
import java.util.Scanner;

/**
 * Este programa implementa el juego "Piedra, Papel, Tijeras, Lagarto, Spock".
 * El usuario elige una opción y el programa elige una opción aleatoria.
 * Luego se determina quién gana y se muestra el resultado.
 */
public class Main {

    /**
     * Método principal que ejecuta el juego.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Generar una opción aleatoria para el programa
        Random rand = new Random();
        int randomNum = rand.nextInt(5) + 1;
        Opcion opcionPrograma = Opcion.obtenerOpcionPorNumero(randomNum);

        // Inicializar el scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
        int salir = 0;

        // Loop principal del juego
        do {
            // Mostrar opciones disponibles al usuario
            System.out.println("Elige el número de la opción:");
            for (Opcion opcion : Opcion.values()) {
                System.out.println(opcion.name() + " (" + opcion.getValor() + ")");
            }
            int opcionElegida = entrada.nextInt();
            Opcion opcionUsuario = Opcion.obtenerOpcionPorNumero(opcionElegida);
            System.out.println("El programa ha elegido: " + opcionPrograma.name());
            System.out.println("Tú has elegido: " + opcionUsuario.name());

            // Obtener resultado y explicación del juego
            String cadenaResultado = obtenerResultado(opcionUsuario, opcionPrograma);
            String cadenaExplicacion = obtenerExplicacion(opcionUsuario, opcionPrograma);
            System.out.println(cadenaResultado + cadenaExplicacion);
            System.out.println("¿Desea jugar de nuevo? 1. SI 2. NO");
            salir = entrada.nextInt();
        } while (salir == 1);

        entrada.close();
    }

    /**
     * Determina el resultado del juego.
     * @param opcionUsuario La opción elegida por el usuario.
     * @param opcionPrograma La opción elegida por el programa.
     * @return Un mensaje indicando si el usuario ganó, perdió o hubo empate.
     */
    private static String obtenerResultado(Opcion opcionUsuario, Opcion opcionPrograma) {
        if (opcionUsuario == opcionPrograma) {
            return "¡Empate! ";
        } else if ((opcionUsuario == Opcion.PIEDRA && opcionPrograma == Opcion.TIJERAS) ||
                (opcionUsuario == Opcion.PIEDRA && opcionPrograma == Opcion.LAGARTO) ||
                (opcionUsuario == Opcion.PAPEL && opcionPrograma == Opcion.PIEDRA) ||
                (opcionUsuario == Opcion.PAPEL && opcionPrograma == Opcion.SPOCK) ||
                (opcionUsuario == Opcion.TIJERAS && opcionPrograma == Opcion.PAPEL) ||
                (opcionUsuario == Opcion.TIJERAS && opcionPrograma == Opcion.LAGARTO) ||
                (opcionUsuario == Opcion.LAGARTO && opcionPrograma == Opcion.SPOCK) ||
                (opcionUsuario == Opcion.LAGARTO && opcionPrograma == Opcion.PAPEL) ||
                (opcionUsuario == Opcion.SPOCK && opcionPrograma == Opcion.TIJERAS) ||
                (opcionUsuario == Opcion.SPOCK && opcionPrograma == Opcion.PIEDRA)) {
            return "¡Ganaste! ";
        } else {
            return "¡Perdiste! ";
        }
    }

    /**
     * Obtiene una explicación detallada de por qué un jugador ganó o perdió.
     * @param opcion1 La opción elegida por el primer jugador.
     * @param opcion2 La opción elegida por el segundo jugador.
     * @return Una cadena que describe la explicación del juego.
     */
    public static String obtenerExplicacion(Opcion opcion1, Opcion opcion2) {
        if ((opcion1 == Opcion.TIJERAS && opcion2 == Opcion.PAPEL) || (opcion1 == Opcion.PAPEL && opcion2 == Opcion.TIJERAS)) {
            return "Tijeras cortan papel.";
        } else if ((opcion1 == Opcion.PIEDRA && opcion2 == Opcion.TIJERAS) || (opcion1 == Opcion.TIJERAS && opcion2 == Opcion.PIEDRA)) {
            return "Piedra aplasta tijeras.";
        } else if ((opcion1 == Opcion.PIEDRA && opcion2 == Opcion.LAGARTO) || (opcion1 == Opcion.LAGARTO && opcion2 == Opcion.PIEDRA)) {
            return "Piedra aplasta lagarto.";
        } else if ((opcion1 == Opcion.PAPEL && opcion2 == Opcion.PIEDRA) || (opcion1 == Opcion.PIEDRA && opcion2 == Opcion.PAPEL)) {
            return "Papel cubre piedra.";
        } else if ((opcion1 == Opcion.LAGARTO && opcion2 == Opcion.SPOCK) || (opcion1 == Opcion.SPOCK && opcion2 == Opcion.LAGARTO)) {
            return "Lagarto envenena Spock.";
        } else if ((opcion1 == Opcion.SPOCK && opcion2 == Opcion.TIJERAS) || (opcion1 == Opcion.TIJERAS && opcion2 == Opcion.SPOCK)) {
            return "Spock destroza tijeras.";
        } else if ((opcion1 == Opcion.TIJERAS && opcion2 == Opcion.LAGARTO) || (opcion1 == Opcion.LAGARTO && opcion2 == Opcion.TIJERAS)) {
            return "Tijeras decapitan lagarto.";
        } else if ((opcion1 == Opcion.LAGARTO && opcion2 == Opcion.PAPEL) || (opcion1 == Opcion.PAPEL && opcion2 == Opcion.LAGARTO)) {
            return "Lagarto come papel.";
        } else if ((opcion1 == Opcion.PAPEL && opcion2 == Opcion.SPOCK) || (opcion1 == Opcion.SPOCK && opcion2 == Opcion.PAPEL)) {
            return "Papel refuta Spock.";
        } else if ((opcion1 == Opcion.SPOCK && opcion2 == Opcion.PIEDRA) || (opcion1 == Opcion.PIEDRA && opcion2 == Opcion.SPOCK)) {
            return "Spock vaporiza piedra.";
        } else {
            return "";
        }
    }
}
