package b400ooavanz.E430GlobosConJugadoresMixtos;

import java.util.List;

public class Juego {
    private static final int RONDAS_PARA_GANAR = 3;
    private static final int TOTAL_RONDAS = 5;

    private List<Jugador> jugadores;

    public Juego(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    // ── Punto de entrada ─────────────────────────────────────────────────────
    public void empezar() {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║   JUEGO DE LOS GLOBOS EXPLOSIVOS ║");
        System.out.println("╚══════════════════════════════════╝");
        mostrarJugadores();

        int numRonda = 1;
        while (numRonda <= TOTAL_RONDAS && !hayGanador()) {
            System.out.println("\n══════ RONDA " + numRonda + " ══════");
            jugarRonda(numRonda);
            mostrarPuntuacion();
            numRonda++;
        }

        System.out.println("\n══════ FIN DEL JUEGO ══════");
        mostrarResultadoFinal();
    }

    // ── Lógica de una ronda ──────────────────────────────────────────────────
    private void jugarRonda(int numRonda) {
        Globo globo = new Globo();   // capacidad aleatoria y desconocida

        // Resetear cansancio de todos al inicio de la ronda
        for (Jugador j : jugadores) {
            j.resetearCansancio();
        }

        boolean explotado = false;

        while (!explotado) {
            for (Jugador j : jugadores) {
                System.out.println("\nTurno de: " + j.getNombre()
                        + "  [máx. soplo esta ronda: " + j.getMaxSoploEstaRonda() + "]");

                int soplo = j.determinarSoplo();
                globo.inflar(soplo);
                j.registrarSoplo(soplo);   // acumula estadísticas y actualiza cansancio

                if (globo.haExplotado()) {
                    System.out.println(globo);
                    System.out.println("¡El globo ha explotado! Capacidad era: "
                            + globo.getCapacidadMax());

                    // Ganan todos los demás jugadores
                    for (Jugador otro : jugadores) {
                        if (otro != j) {
                            otro.ganarRonda();
                        }
                    }
                    System.out.println("→ " + j.getNombre() + " pierde la ronda.");

                    explotado = true;
                    break;
                } else {
                    System.out.println(globo);
                }
            }
        }
    }

    // Condición de victoria
    private boolean hayGanador() {
        for (Jugador j : jugadores) {
            if (j.getRondasGanadas() >= RONDAS_PARA_GANAR) {
                return true;
            }
        }
        return false;
    }

    // Mostrar estado
    private void mostrarJugadores() {
        System.out.println("\nJugadores:");
        for (Jugador j : jugadores) {
            String tipo = (j instanceof JugadorHumano) ? "Humano" : "CPU";
            System.out.println("  · " + j.getNombre() + " (" + tipo + ")");
        }
    }

    private void mostrarPuntuacion() {
        System.out.println("\nPuntuación tras la ronda:");
        for (Jugador j : jugadores) {
            System.out.println("  " + j.getNombre() + ": " + j.getRondasGanadas() + " rondas ganadas");
        }
    }

    private void mostrarResultadoFinal() {
        // Ganador: el que más rondas ha ganado
        Jugador ganador = jugadores.get(0);
        for (Jugador j : jugadores) {
            if (j.getRondasGanadas() > ganador.getRondasGanadas()) {
                ganador = j;
            }
        }

        System.out.println("\nPuntuación final:");
        for (Jugador j : jugadores) {
            System.out.println("  " + j.getNombre()
                    + " → rondas ganadas: " + j.getRondasGanadas()
                    + " | aire total soplado: " + j.getAireTotalSoplado());
        }

        // Comprobar empate
        boolean empate = false;
        for (Jugador j : jugadores) {
            if (j != ganador && j.getRondasGanadas() == ganador.getRondasGanadas()) {
                empate = true;
                break;
            }
        }

        if (empate) {
            System.out.println("\n¡Empate! Nadie gana.");
        } else {
            System.out.println("\n¡" + ganador.getNombre() + " gana el juego!");
        }
    }
}