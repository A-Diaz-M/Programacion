package b400ooavanz.E430GlobosConJugadoresMixtos;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private static final Scanner teclado = new Scanner(System.in);

    public JugadorHumano(String nombre) {
        super(nombre);
    }

    @Override
    public int determinarSoplo() {
        int soplo = 0;
        int max = getMaxSoploEstaRonda();

        do {
            System.out.print(getNombre() + ", ¿cuánto soplas? (1-" + max + "): ");
            try {
                soplo = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  → Número no válido, intenta de nuevo.");
                soplo = 0;
            }
            if (soplo < 1 || soplo > max) {
                System.out.println("  → Debe estar entre 1 y " + max + ".");
            }
        } while (soplo < 1 || soplo > max);

        return soplo;
    }
}
