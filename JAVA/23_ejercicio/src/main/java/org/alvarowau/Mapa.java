package org.alvarowau;

import java.util.Random;
import java.util.Scanner;
/**
 * La clase Mapa representa un juego de búsqueda de tesoro en un mapa cuadriculado.
 * Los jugadores ingresan coordenadas para encontrar el tesoro oculto en el mapa.
 * El juego ofrece diferentes niveles de dificultad y muestra pistas visuales para ayudar a los jugadores.
 */
public class Mapa {
    // Tamaño del mapa
    private static int MAPA_TAMANO;
    // Caracteres especiales
    private static final char TESORO = '\u2605'; // Carácter del tesoro
    private static final char PUNTO = '\u25CF'; // Carácter de punto
    private static char[] LISTA_LETRAS; // Lista de letras para las coordenadas

    // Contador de intentos
    private int contador = 0;
    // Mapa visible para el jugador
    private char[][] mapa_mostrar;
    // Mapa de solución que contiene la ubicación del tesoro y pistas
    private char[][] mapa_solucion;
    // Coordenadas del tesoro
    private int tesoroX;
    private int tesoroY;

    /**
     * Constructor de la clase Mapa.
     * Selecciona la dificultad del juego, inicializa los mapas y coloca el tesoro en una ubicación aleatoria.
     */
    public Mapa() {
        seleccionarDificultad();
        mapa_mostrar = new char[MAPA_TAMANO][MAPA_TAMANO];
        mapa_solucion = new char[MAPA_TAMANO][MAPA_TAMANO];
        llenarListaLetras();
        Random r = new Random();
        tesoroX = r.nextInt(MAPA_TAMANO - 1) + 1;
        tesoroY = r.nextInt(MAPA_TAMANO - 1) + 1;
        llenarMapaMostrar();
        llenarMapaSolucion();
    }

    // Métodos privados para inicializar el juego y los mapas

    // Inicializa la lista de letras para las coordenadas
    private void llenarListaLetras() {
        LISTA_LETRAS = new char[MAPA_TAMANO - 1];
        for (int i = 0; i < LISTA_LETRAS.length; i++) {
            LISTA_LETRAS[i] = (char) ('A' + i);
        }
    }

    // Permite al usuario seleccionar la dificultad del juego
    private void seleccionarDificultad() {
        Scanner entrada = new Scanner(System.in);
        int dificultad;
        do {
            System.out.println("MENU DIFICULTAD");
            System.out.println("1. FACIL");
            System.out.println("2. MEDIO");
            System.out.println("3. DIFICIL");
            dificultad = entrada.nextInt();
        } while (dificultad < 1 || dificultad > 3);
        switch (dificultad) {
            case 1:
                MAPA_TAMANO = 10;
                break;
            case 2:
                MAPA_TAMANO = 15;
                break;
            case 3:
                MAPA_TAMANO = 20;
                break;
            default:
                MAPA_TAMANO = 7;
        }
        entrada.close();
    }

    // Llena el mapa de solución con pistas visuales y el tesoro
    private void llenarMapaSolucion() {
        for (int i = 0; i < MAPA_TAMANO; i++) {
            for (int j = 0; j < MAPA_TAMANO; j++) {
                if (i == 0 && j > 0) {
                    mapa_solucion[i][j] = LISTA_LETRAS[j - 1];
                } else if (j == 0 && i > 0) {
                    mapa_solucion[i][j] = LISTA_LETRAS[i - 1];
                } else if (i == tesoroY && j == tesoroX) {
                    mapa_solucion[i][j] = TESORO;
                } else if (i > 0 && j > 0) {
                    mapa_solucion[i][j] = calcularFlecha(i, j);
                } else {
                    mapa_solucion[i][j] = ' ';
                }
            }
        }
    }

    // Llena el mapa visible para el jugador con puntos de referencia
    private void llenarMapaMostrar() {
        for (int i = 0; i < MAPA_TAMANO; i++) {
            for (int j = 0; j < MAPA_TAMANO; j++) {
                if (i == 0 && j > 0) {
                    mapa_mostrar[i][j] = LISTA_LETRAS[j - 1];
                } else if (j == 0 && i > 0) {
                    mapa_mostrar[i][j] = LISTA_LETRAS[i - 1];
                } else if (i > 0 && j > 0) {
                    mapa_mostrar[i][j] = PUNTO;
                } else {
                    mapa_mostrar[i][j] = ' ';
                }
            }
        }
    }

    // Calcula la flecha que indica la dirección del tesoro
    private char calcularFlecha(int i, int j) {
        char FLECHA_ABAJO = '\u2193';
        char FLECHA_ARRIBA = '\u2191';
        char FLECHA_DERECHA = '\u2192';
        char FLECHA_IZQUIERDA = '\u2190';
        if (i < tesoroY) return FLECHA_ABAJO;
        if (i > tesoroY) return FLECHA_ARRIBA;
        if (j < tesoroX) return FLECHA_DERECHA;
        if (j > tesoroX) return FLECHA_IZQUIERDA;
        return PUNTO;
    }

    /**
     * Muestra el mapa del juego con las pistas visuales y las coordenadas.
     */
    public void mostrarMapaJuego() {
        System.out.println("Mapa del Tesoro:");
        mostrar(mapa_mostrar);
    }

    // Muestra el mapa en la consola
    private void mostrar(char[][] mapa) {
        System.out.println();
        for (char[] chars : mapa) {
            for (char aChar : chars) {
                System.out.print(" " + aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

/**
 * Comprueba si las coordenadas ingresadas por el jugador contienen el tesoro.
 * @param ejex La coordenada X ingresada por el jugador.
 * @param ejey La coordenada Y ingresada por el jugador.
 * @return true si el tesoro es encontrado, false de lo contrario.
 */
public boolean comprobar(int ejex, int ejey) {
    if (ejex > 0 && ejex < MAPA_TAMANO && ejey > 0 && ejey < MAPA_TAMANO) {
        contador++;
        if (ejex == tesoroY && ejey == tesoroX) {
            System.out.println("¡FELICIDADES! HAS ENCONTRADO EL TESORO");
            System.out.println("Necesitaste " + (contador == 1 ? " una oportunidad" : " " + contador + " oportunidades"));
            return true;
        } else {
            mapa_mostrar[ejex][ejey] = mapa_solucion[ejex][ejey];
            mostrarMapaJuego();
        }
    } else {
        System.out.println("El valor no es válido, por favor elija un número que esté dentro del rango permitido");
    }
    return false;
}

    /**
     * Inicia el juego de búsqueda del tesoro, solicitando al jugador ingresar las coordenadas
     * hasta que el tesoro sea encontrado.
     */
    public void juego() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
        boolean encontrado = false;

        // Bucle que se ejecuta hasta que se encuentra el tesoro
        do {
            // Solicitar al usuario la letra de la coordenada X y convertirla a mayúsculas
            System.out.print("Ingrese la letra de la coordenada X (A-" + (char) ('A' + MAPA_TAMANO - 2) + "): ");
            char letra = entrada.next().toUpperCase().charAt(0);

            // Convertir la letra de la coordenada X en un número correspondiente
            int x = letra - 'A' + 1;

            // Solicitar al usuario la letra de la coordenada Y y convertirla a mayúsculas
            System.out.print("Ingrese la letra de la coordenada Y (A-" + (char) ('A' + MAPA_TAMANO - 2) + "): ");
            letra = entrada.next().toUpperCase().charAt(0);

            // Convertir la letra de la coordenada Y en un número correspondiente
            int y = letra - 'A' + 1;

            // Verificar si las coordenadas ingresadas contienen el tesoro
            encontrado = comprobar(x, y);
        } while (!encontrado); // Continuar el bucle mientras el tesoro no se encuentre

        // Cerrar el objeto Scanner para liberar recursos
        entrada.close();
    }
}

