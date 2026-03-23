package b400ooavanz.E431GlobosDeDistintosTipos;

import java.util.*;

public class Principal {

    private static Globo crearGloboAleatorio() {
        return switch (new Random().nextInt(3)) {
            case 0 -> new GloboNormal();
            case 1 -> new GloboDefectuoso();
            default -> new GloboFlexible();
        };
    }

    public static void main(String[] args) {

        int vidasPorJugador = 3;

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new JugadorCpu("Fulanito", vidasPorJugador));
        jugadores.add(new JugadorCpu("Menganita", vidasPorJugador));
        jugadores.add(new JugadorHumano("Tú", vidasPorJugador));  // jugador humano
        jugadores.add(new JugadorCpu("Zutanito", vidasPorJugador));
        jugadores.add(new JugadorCpu("Fulanítez", vidasPorJugador));

        int jugadoresVivos = jugadores.size();
        int jugadorActual = -1;

        int ronda = 0;
        do {
            ronda++;

            System.out.printf("\n\n\n---------- RONDA %d ----------\n", ronda);
            for (Jugador j : jugadores) System.out.printf("  - %s\n", j);

            Globo globo = crearGloboAleatorio();
            System.out.println("\nGlobo de esta ronda: " + globo);

            do {
                // Saltar jugadores eliminados
                do {
                    jugadorActual = (jugadorActual + 1) % jugadores.size();
                } while (!jugadores.get(jugadorActual).estaVivo());

                jugadores.get(jugadorActual).soplar(globo);
                System.out.println(globo);

            } while (!globo.explotado());

            Jugador perdedor = jugadores.get(jugadorActual);
            perdedor.quitarUnaVida();
            System.out.printf("  💥 ¡El globo ha explotado! %s pierde una vida.\n", perdedor.getNombre());

            if (!perdedor.estaVivo()) {
                jugadoresVivos--;
                System.out.printf("  ☠  %s ha sido eliminado.\n", perdedor.getNombre());
            }

        } while (jugadoresVivos > 1);

        // Ordenar de mayor a menor puntuación
        jugadores.sort(Comparator.reverseOrder());

        System.out.printf("\n\n\n---------- FINAL DEL JUEGO TRAS %d RONDAS ----------\n", ronda);
        for (Jugador j : jugadores) System.out.printf("  - %s\n", j);
        System.out.printf("\n Por lo tanto, el ganador es:\n  %s\n\n\n", jugadores.getFirst());
    }
}