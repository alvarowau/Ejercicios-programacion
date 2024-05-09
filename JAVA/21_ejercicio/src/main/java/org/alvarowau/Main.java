package org.alvarowau;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random r = new Random();
    private static Scanner entrada = new Scanner(System.in);
    private static int dineroGastado = 0;
    private static int dineroGanado = 0;
    private static int diasPasados = 0;

    public static void main(String[] args) {
        System.out.print("Introduzca un número de lotería (de 0 a 99999): ");
        int loteria = entrada.nextInt();

        System.out.print("Cuántos días quieres jugar el número " + loteria + ": ");
        int diasJugados = entrada.nextInt();

        comprobarLoteria(loteria, crearNumeroSerie(), diasJugados);

        // Mostrar resultados
        System.out.println("Dinero gastado: " + dineroGastado + " euros.");
        System.out.println("Dinero ganado: " + dineroGanado + " euros.");
        System.out.println("Días jugados: " + diasJugados + ".");
        System.out.println("Días pasados: " + diasPasados + ".");

        // Calcular tiempo y dinero hasta ganar
        Resultado resultado = calcularTiempoHastaGanar(loteria, crearNumeroSerie());

        System.out.println("Para ganar el gran premio, tardó " + resultado.diasParaGanar + " días.");
        System.out.println("Dinero gastado total: " + resultado.dineroGastado + " euros.");
        System.out.println("Dinero ganado durante el proceso: " + resultado.dineroGanado + " euros.");
        System.out.println("Costo neto: " + (resultado.dineroGastado - resultado.dineroGanado) + " euros.");
    }

    // Método para comprobar la lotería durante un número específico de días
    private static void comprobarLoteria(int loteria, int serieUsuario, int dias) {
        for (int i = 0; i < dias; i++) {
            int loteriaDiaria = crearNumeroLoteria(); // Número del sorteo diario
            int serieDiaria = crearNumeroSerie(); // Serie diaria
            dineroGastado += 20; // Gastar 20 euros por cada día jugado

            // Calcular dinero ganado y sumar al acumulado
            dineroGanado += calcularPremio(loteria, serieUsuario, loteriaDiaria, serieDiaria);

            diasPasados++; // Incrementar el número de días pasados
        }
    }

    // Método para calcular cuánto dinero se gana con cada sorteo
    private static int calcularPremio(int loteria, int serieUsuario, int loteriaDiaria, int serieDiaria) {
        if (loteria == loteriaDiaria && serieUsuario == serieDiaria) {
            return 500000; // Gran premio
        } else if (loteria == loteriaDiaria) {
            return 20000; // Coincidencia del número
        } else if (dividirNumeros(loteria, 4) == dividirNumeros(loteriaDiaria, 4)) {
            return 5000; // Coincidencia de 4 dígitos
        } else if (dividirNumeros(loteria, 3) == dividirNumeros(loteriaDiaria, 3)) {
            return 1000; // Coincidencia de 3 dígitos
        } else if (dividirNumeros(loteria, 2) == dividirNumeros(loteriaDiaria, 2)) {
            return 100; // Coincidencia de 2 dígitos
        }

        return 0; // Si no hay coincidencias, no se gana nada
    }

    private static Resultado calcularTiempoHastaGanar(int numeroLoteria, int serieUsuario) {
        int diasParaGanar = 0;
        int dineroGastado = 0;
        int dineroGanado = 0;
        boolean ganador = false;

        while (!ganador) {
            diasParaGanar++; // Incrementar el número de días jugados
            dineroGastado += 20; // Gastar 20 euros por cada día jugado

            int loteriaDiaria = crearNumeroLoteria(); // Número del sorteo diario
            int serieDiaria = crearNumeroSerie(); // Serie del sorteo diario

            int premio = calcularPremio(numeroLoteria, serieUsuario, loteriaDiaria, serieDiaria);

            dineroGanado += premio; // Sumar el premio obtenido

            if (premio == 500000) { // Si se gana el gran premio
                ganador = true;
            }
        }

        return new Resultado(diasParaGanar, dineroGastado, dineroGanado); // Retornar el resultado
    }

    private static int dividirNumeros(int numero, int cifras) {
        int divisor = (int) Math.pow(10, cifras);
        return numero % divisor; // Últimas cifras
    }

    private static int crearNumeroLoteria() {
        return r.nextInt(100000); // Generar número de 0 a 99999
    }

    private static int crearNumeroSerie() {
        return r.nextInt(186); // Generar serie de 0 a 185
    }

    private static class Resultado {
        int diasParaGanar;
        int dineroGastado;
        int dineroGanado;

        Resultado(int diasParaGanar, int dineroGastado, int dineroGanado) {
            this.diasParaGanar = diasParaGanar;
            this.dineroGastado = dineroGastado;
            this.dineroGanado = dineroGanado;
        }
    }
}
