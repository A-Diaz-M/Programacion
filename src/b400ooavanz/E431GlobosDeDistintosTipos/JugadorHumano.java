package b400ooavanz.E431GlobosDeDistintosTipos;

import java.util.Scanner;

public class JugadorHumano extends Jugador {

    private static final Scanner teclado = new Scanner(System.in);

    public JugadorHumano(String nombre, int vidas) {
        super(nombre, vidas);
    }

    @Override
    public int determinarSoplo() {
        int soplo = -1;
        boolean valido = false;

        while (!valido) {
            System.out.printf("  %s, ¿cuánto soplas? (%d-%d): ", getNombre(), SOPLO_MINIMO, SOPLO_MAXIMO);

            if (teclado.hasNextInt()) {
                soplo = teclado.nextInt();
                if (soplo >= SOPLO_MINIMO && soplo <= SOPLO_MAXIMO) {
                    valido = true;
                } else {
                    System.out.printf("  ⚠ Valor fuera de rango. Introduce un número entre %d y %d.\n",
                            SOPLO_MINIMO, SOPLO_MAXIMO);
                }
            } else {
                System.out.println("  ⚠ Entrada inválida. Introduce un número entero.");
                teclado.next();
            }
        }
        return soplo;
    }
}