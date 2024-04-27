package org.alvarowau;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array bidimensional con preguntas y respuestas sobre Java
        String[][] preguntasJava = {
                {"¿Cuál es el método principal en un programa Java?", "main"},
                {"¿Qué palabra clave se usa para crear una clase en Java?", "class"},
                {"¿Cuál es el tipo de datos para almacenar un número entero en Java?", "int"},
                {"¿Qué palabra clave se usa para heredar de otra clase?", "extends"},
                {"¿Cuál es el tipo de datos para almacenar texto en Java?", "String"},
                {"¿Qué palabra clave se usa para crear un método que no devuelve un valor?", "void"},
                {"¿Qué palabra clave se usa para declarar una interfaz en Java?", "interface"},
                {"¿Qué palabra clave se usa para importar paquetes en Java?", "import"},
                {"¿Cuál es el tipo de datos para almacenar un número de punto flotante en Java?", "float"},
                {"¿Cuál es el tipo de datos para almacenar un valor booleano?", "boolean"},
                {"¿Cuál es el operador para concatenar cadenas de texto en Java?", "+"},
                {"¿Cuál es el método para imprimir texto en la consola?", "println"},
                {"¿Cuál es el método para obtener el tamaño de un ArrayList?", "size"},
                {"¿Qué operador se usa para comparar si dos valores son iguales en Java?", "=="},
                {"¿Qué operador se usa para asignar un valor a una variable?", "="},
                {"¿Cuál es el ciclo que garantiza que se ejecutará al menos una vez?", "do-while"},
                {"¿Qué palabra clave se usa para crear una excepción personalizada?", "throw"},
                {"¿Qué palabra clave se usa para capturar excepciones?", "catch"},
                {"¿Cuál es el operador para obtener el residuo de una división?", "%"},
                {"¿Qué palabra clave se usa para declarar una variable constante?", "final"}
        };

        ArrayList<Integer> preguntasUsadas = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int aciertosConsecutivos = 0;
        int aciertosTotales = 0;
        int errores = 0;

        // Mostrar las reglas del juego
        System.out.println("¡Bienvenido al juego de adivinanzas sobre Java!");
        System.out.println("Reglas:");
        System.out.println("1. Tienes que acertar 3 preguntas consecutivas para ganar.");
        System.out.println("2. Tienes intentos ilimitados, pero cada fallo reinicia tu cuenta de aciertos consecutivos.");
        System.out.println("3. Las preguntas pueden repetirse después de ser utilizadas.");
        System.out.println("Buena suerte!");
        System.out.println();

        // Bucle principal del juego
        while (aciertosConsecutivos < 3) {
            int numeroPregunta;

            // Generar un número aleatorio y asegurarse de que no se haya usado antes
            do {
                numeroPregunta = random.nextInt(preguntasJava.length);
            } while (preguntasUsadas.contains(numeroPregunta));

            preguntasUsadas.add(numeroPregunta);

            System.out.println("Pregunta: " + preguntasJava[numeroPregunta][0]);
            System.out.print("Tu respuesta: ");
            String respuestaUsuario = scanner.nextLine().trim().toLowerCase();

            if (respuestaUsuario.equals(preguntasJava[numeroPregunta][1].toLowerCase())) {
                aciertosConsecutivos++;
                aciertosTotales++;
                System.out.println("¡Correcto! Aciertos consecutivos: " + aciertosConsecutivos + ", Aciertos totales: " + aciertosTotales + ", Errores: " + errores);
            } else {
                aciertosConsecutivos = 0; // Reiniciar la cuenta de aciertos consecutivos
                errores++; // Aumentar el contador de errores
                System.out.println("Incorrecto. La respuesta era: " + preguntasJava[numeroPregunta][1] + ". Aciertos totales: " + aciertosTotales + ", Errores: " + errores);
            }

            // Si se han usado todas las preguntas, reiniciar el array de preguntas usadas
            if (preguntasUsadas.size() == preguntasJava.length) {
                preguntasUsadas.clear(); // Limpiar para permitir que las preguntas se repitan
            }

            System.out.println(); // Línea en blanco para separar las preguntas
        }

        System.out.println("¡Ganaste! Has acertado 3 preguntas seguidas. Aciertos totales: " + aciertosTotales + ", Errores: " + errores);

        scanner.close();
    }
}
