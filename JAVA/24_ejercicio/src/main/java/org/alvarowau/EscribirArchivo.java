package org.alvarowau;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirArchivo {

    private Scanner entrada;

    public EscribirArchivo(){
        entrada = new Scanner(System.in);
    }

    public void start(){
        leerArchivo();

        crearArchivo();
    }

    private void leerArchivo(){
        try {
            File ficheroDatos = new File("datos.txt");
            Scanner lectorDatos = new Scanner(ficheroDatos);
            while (lectorDatos.hasNextLine()){
                String datos = lectorDatos.nextLine();
                System.out.println(datos);
            }
            lectorDatos.close();
        }catch(FileNotFoundException error){
            System.out.println("Error al abrir el fichero para lectura.");
        }
    }

    private void crearArchivo(){
        try {
            FileWriter archivo = new FileWriter("datos.txt", true);
            System.out.println("Introduzca siguiente linea:");
            String linea = entrada.nextLine();
            archivo.write(linea + "\n");
            archivo.close();
        }catch (IOException e){
            System.out.println("EEROR");
        }
    }
}