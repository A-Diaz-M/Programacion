package b300oobasica.E322GlobosExplosivosFase3ConArrayList;

import b300oobasica.E320GlobosExplosivos.Globo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        final int MAX_RONDAS = 5;
        final int VICTORIAS_PARA_GANAR = 3;

        ArrayList<Globo> globos = new ArrayList<>();

        int victoriasJ1 = 0;
        int victoriasJ2 = 0;
        int ronda = 0;

        System.out.println("=== GLOBOS EXPLOSIVOS ===");

        while (ronda < MAX_RONDAS &&
                victoriasJ1 < VICTORIAS_PARA_GANAR &&
                victoriasJ2 < VICTORIAS_PARA_GANAR) {

            System.out.println("\n--- RONDA " + (ronda + 1) + " ---");

            Globo globo = new Globo();
            globos.add(globo);

            int jugadorActual = 1;

            while (!globo.estaExplotado()) {

                System.out.printf(
                        """
                        Jugador %d, ¿cuánto quieres soplar?
                        1. Poco
                        2. Medio
                        3. Mucho
                        4. Random
                        """,
                        jugadorActual
                );

                int opcion = teclado.nextInt();
                int cantidad;

                switch (opcion) {
                    case 1 -> cantidad = random.nextInt(1, 6);
                    case 2 -> cantidad = random.nextInt(5, 11);
                    case 3 -> cantidad = random.nextInt(10, 21);
                    case 4 -> cantidad = random.nextInt(1, 100);
                    default -> {
                        System.out.println("Opción inválida, se sopla random.");
                        cantidad = random.nextInt(1, 100);
                    }
                }

                System.out.println("Se soplan " + cantidad + " unidades de aire");
                globo.inflar(cantidad);

                if (globo.estaExplotado()) {
                    System.out.println("¡El globo ha explotado!");
                    System.out.println(globo);

                    if (jugadorActual == 1) {
                        victoriasJ2++;
                        System.out.println("Gana la ronda el Jugador 2");
                    } else {
                        victoriasJ1++;
                        System.out.println("Gana la ronda el Jugador 1");
                    }
                }

                jugadorActual = (jugadorActual == 1) ? 2 : 1;
            }

            System.out.println("Marcador:");
            System.out.println("Jugador 1: " + victoriasJ1);
            System.out.println("Jugador 2: " + victoriasJ2);

            ronda++;
        }

        System.out.println("\n=== FIN DEL JUEGO ===");
        System.out.println(
                victoriasJ1 > victoriasJ2
                        ? "Ha ganado el Jugador 1"
                        : "Ha ganado el Jugador 2"
        );

        System.out.println("\nEstado final de los globos:");
        for (int i = 0; i < globos.size(); i++) {
            System.out.println("Globo " + (i + 1) + ": " + globos.get(i));
        }
    }
}