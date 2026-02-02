package b300oobasica.E320GlobosExplosivos;

import java.util.Scanner;
import java.util.Random;

public class Principal {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        final int MAX_RONDAS = 5;
        final int VICTORIAS_PARA_GANAR = 3;

        Globo[] globos = new Globo[MAX_RONDAS];

        int victoriasJ1 = 0;
        int victoriasJ2 = 0;

        int ronda = 0;

        System.out.println("=== GLOBOS EXPLOSIVOS ===");

        while (ronda < MAX_RONDAS &&
                victoriasJ1 < VICTORIAS_PARA_GANAR &&
                victoriasJ2 < VICTORIAS_PARA_GANAR) {

            System.out.println("\n--- RONDA " + (ronda + 1) + " ---");

            globos[ronda] = new Globo();
            Globo globo = globos[ronda];

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
                int cantidad = 0;

                switch (opcion) {
                    case 1 -> cantidad = random.nextInt(1, 6);
                    case 2 -> cantidad = random.nextInt(5, 11);
                    case 3 -> cantidad = random.nextInt(10, 21);
                    case 4 -> cantidad = random.nextInt(1, 100);
                    default -> {
                        System.out.println("Opción inválida, se sopla random por poner un numero invalido. :D");
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
        if (victoriasJ1 > victoriasJ2) {
            System.out.println("Ha ganado el Jugador 1");
        } else {
            System.out.println("Ha ganado el Jugador 2");
        }

        System.out.println("\nEstado final de los globos:");
        for (int i = 0; i < globos.length; i++) {
            if (globos[i] != null) {
                System.out.println("Globo " + (i + 1) + ": " + globos[i]);
            }
        }
    }
}