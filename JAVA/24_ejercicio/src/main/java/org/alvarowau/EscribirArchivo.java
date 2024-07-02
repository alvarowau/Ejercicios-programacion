package org.alvarowau;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirArchivo {

    private Scanner entrada;


    public EscribirArchivo() {
        entrada = new Scanner(System.in);
    }

    
    public void start() {
        while (true) {
            // Menú de opciones
            String menu = """
                    1. Leer archivo
                    2. Crear archivo
                    3. Modificar archivo
                    4. Salir
                    (digite el número de la opción)
                    """;
            System.out.println(menu);
            int opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            // Manejo de opciones del menú
            switch (opcion) {
                case 1 -> leerArchivo();
                case 2 -> crearArchivo();
                case 3 -> modificarArchivo();
                case 4 -> salir();
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método para modificar un archivo existente
    private void modificarArchivo() {
        System.out.print("Digite el nombre del archivo que desea modificar: ");
        String nombreArchivo = entrada.nextLine() + ".txt";
        if (archivoExiste(nombreArchivo)) {
            agregarLineaArchivo(nombreArchivo);
        } else {
            System.out.println("El nombre digitado no coincide con ningún archivo.");
        }
    }

    // Método para salir del programa
    private void salir() {
        entrada.close();
        System.exit(0);
    }

    // Método para leer un archivo
    private void leerArchivo() {
        System.out.print("Digite el nombre del archivo que quiera leer: ");
        String nombre = entrada.nextLine();
        String nombreArchivo = nombre + ".txt";
        try {
            File ficheroDatos = new File(nombreArchivo);
            Scanner lectorDatos = new Scanner(ficheroDatos);
            while (lectorDatos.hasNextLine()) {
                String datos = lectorDatos.nextLine();
                System.out.println(datos);
            }
            lectorDatos.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error al abrir el fichero para lectura.");
        }
    }

    // Método para comprobar si un archivo existe
    private boolean archivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    // Método para crear un nuevo archivo
    private void crearArchivo() {
        System.out.print("Digite el nombre del archivo que quiere crear: ");
        String nombreArchivo = entrada.nextLine() + ".txt";
        if (archivoExiste(nombreArchivo)) {
            // Si el archivo ya existe, preguntar al usuario si quiere modificarlo
            String mensaje = """
                    El archivo ya existe ¿Quiere modificarlo?
                    (s-S/n-N)
                    """;
            System.out.println(mensaje);
            char opcion = entrada.next().charAt(0);
            entrada.nextLine(); // Consumir el salto de línea
            if (opcion == 's' || opcion == 'S') {
                agregarLineaArchivo(nombreArchivo);
            }
        } else {
            crearNuevoArchivo(nombreArchivo);
        }
    }

    // Método para crear un nuevo archivo y añadir la primera línea
    private void crearNuevoArchivo(String nombreArchivo) {
        try {
            FileWriter archivo = new FileWriter(nombreArchivo, false);
            System.out.println("Introduzca la primera línea:");
            String linea = entrada.nextLine();
            archivo.write(linea + "\n");
            archivo.close();
            System.out.println("Archivo creado y línea añadida.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    // Método para añadir una línea a un archivo existente
    private void agregarLineaArchivo(String nombreArchivo) {
        try {
            FileWriter archivo = new FileWriter(nombreArchivo, true);
            System.out.println("Introduzca la línea que desea añadir:");
            String linea = entrada.nextLine();
            archivo.write(linea + "\n");
            archivo.close();
            System.out.println("Línea añadida al archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    
}
