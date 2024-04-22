package org.alvarowau;

/**
 * Enumeración que representa las opciones del juego "Piedra, Papel, Tijeras, Lagarto, Spock".
 */
public enum Opcion {
    PIEDRA(1),
    PAPEL(2),
    TIJERAS(3),
    LAGARTO(4),
    SPOCK(5);

    private final int valor;

    /**
     * Constructor de la enumeración Opcion.
     * @param valor El valor asociado a la opción.
     */
    Opcion(int valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el valor asociado a la opción.
     * @return El valor asociado a la opción.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene la opción correspondiente al número especificado.
     * @param numero El número de la opción.
     * @return La opción correspondiente al número especificado, o null si no se encuentra.
     */
    public static Opcion obtenerOpcionPorNumero(int numero) {
        for (Opcion opcion : Opcion.values()) {
            if (opcion.getValor() == numero) {
                return opcion;
            }
        }
        return null;
    }
}
