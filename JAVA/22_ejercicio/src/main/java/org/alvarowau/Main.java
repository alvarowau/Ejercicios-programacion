package org.alvarowau;

import java.util.Random;
import java.util.Scanner;

/**
 * Programa para simular la tirada de dados y calcular el tiempo para obtener todos los números iguales.
 */
public class Main {

    private static Scanner entrada = new Scanner(System.in);
    private static Random r = new Random();

    /**
     * Método principal que inicia el programa.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        seleccionMenuPrincipal();
    }

    /**
     * Muestra el menú principal y procesa la selección del usuario.
     */
    private static void seleccionMenuPrincipal(){
        int[] valoresCreacion = null;
        menuPrincipal();
        int selec = recogerNumeroTeclado("Seleccione un numero: ");
        if(selec == 1 || selec == 2){
            valoresCreacion = recogerDadosCaras();
        }
        switch(selec){
            case 1: creacionDados(valoresCreacion);
                break;
            case 2: creacionDadosIguales(valoresCreacion);
                break;
            case 3: salirAPP();
            default: seleccionMenuPrincipal();
        }
    }

    /**
     * Sale de la aplicación.
     */
    private static void salirAPP(){
        System.out.println("Saliendo vuelva pronto");
        entrada.close();
        System.exit(0);
    }

    /**
     * Muestra el menú principal.
     */
    private static void menuPrincipal(){
        System.out.println("----DADOS AL AZAR----");
        System.out.println("1. Tirada de dados al azar.");
        System.out.println("2. ¿Cuantas tiradas hacen falta para que salgan iguales.?");
        System.out.println("3. Salir.");
    }

    /**
     * Crea y muestra los dados tirados de forma aleatoria.
     * @param valoresCreacion Array que contiene la cantidad de dados y el número de caras.
     */
    private static void creacionDados(int[] valoresCreacion) {
        int numeroDados = valoresCreacion[0];
        int caras = valoresCreacion[1];
        System.out.println("\n");
        for (int i = 0; i < numeroDados ; i++) {
            System.out.println("dado" + (i+1) + ": " + r.nextInt(1, (caras+1)));
        }
        System.out.println("\n");
        seleccionMenuPrincipal();
    }

    /**
     * Calcula cuántas tiradas son necesarias para que salgan todos los números iguales.
     * @param valoresCreacion Array que contiene la cantidad de dados y el número de caras.
     */
    private static void creacionDadosIguales(int[] valoresCreacion) {
        int numeroDados = valoresCreacion[0];
        int caras = valoresCreacion[1];
        int [] numerosGenerados = new int[numeroDados];
        int contador = 0;
        do {
            contador ++;
            for (int i = 0; i < numerosGenerados.length; i++) {
                numerosGenerados[i] = r.nextInt(1, (caras+1));
            }
        }while(! isDadosIguales(numerosGenerados));
        System.out.println("\n");

        System.out.println("Hicieron falta " + contador + " tiradas.");
        seleccionMenuPrincipal();
    }

    /**
     * Comprueba si todos los dados tienen el mismo número.
     * @param numerosGenerados Array que contiene los números de los dados.
     * @return true si todos los números son iguales, false de lo contrario.
     */
    private static boolean isDadosIguales(int[] numerosGenerados) {
        int numero = numerosGenerados[0];
        for (int i = 0; i < numerosGenerados.length; i++) {
            if(numero != numerosGenerados[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Recoge la cantidad de dados y el número de caras del usuario.
     * @return Array que contiene la cantidad de dados y el número de caras.
     */
    private static int[] recogerDadosCaras(){
        int[] dados = new int[2];
        dados[0] = recogerNumeroTeclado("Digite el número de dados: ");
        dados[1] = recogerNumeroTeclado("Digite el número de caras del dado; ");
        return dados;
    }

    /**
     * Recoge un número del teclado ingresado por el usuario.
     * @param mensaje Mensaje que indica al usuario qué número debe ingresar.
     * @return El número ingresado por el usuario.
     */
    private static int recogerNumeroTeclado(String mensaje){
        String recogido = "";
        do{
            System.out.print(mensaje);
            recogido = entrada.nextLine();
        }while (! isNumero(recogido));
        return Integer.parseInt(recogido);
    }

    /**
     * Comprueba si una cadena de texto puede convertirse en un número entero.
     * @param recogido Cadena de texto ingresada por el usuario.
     * @return true si la cadena puede convertirse en un número entero, false de lo contrario.
     */
    private static boolean isNumero(String recogido){
        try{
            int valor = Integer.parseInt(recogido);
            return true;
        }catch (NumberFormatException e){
            System.out.println("introduzca un valor numerico");
            return false;
        }
    }
}
