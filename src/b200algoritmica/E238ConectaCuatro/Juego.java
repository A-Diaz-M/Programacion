package b200algoritmica.E238ConectaCuatro;

import java.util.Scanner;

public class Juego {
    private final Tablero tablero;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Scanner teclado;

    public Juego(int filas, int columnas) {
        this.tablero = new Tablero(filas, columnas);
        this.jugador1 = new Jugador(1, "Jugador 1", "[X]");
        this.jugador2 = new Jugador(2, "Jugador 2", "[O]");
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        mostrarBienvenida();

        boolean seguirJugando = true;
        while (seguirJugando) {
            jugarPartida();
            seguirJugando = preguntarRevancha();
        }

        System.out.println("\n¡Hasta la próxima!");
        teclado.close();
    }

    private void jugarPartida() {
        Tablero tableroPartida = new Tablero(tablero.getFilas(), tablero.getColumnas());
        Jugador turnoActual = jugador1;
        boolean finalizado = false;

        tableroPartida.mostrar(jugador1, jugador2);

        while (!finalizado) {

            // El jugador solo indica la columna
            int col = pedirColumna(turnoActual, tableroPartida);

            // Colocar ficha y obtener la fila donde cayó (Pista 2)
            int fila = tableroPartida.colocarFicha(col, turnoActual);

            tableroPartida.mostrar(jugador1, jugador2);

            // Comprobar victoria (Pista 4)
            if (tableroPartida.hayVictoria(fila, col, turnoActual)) {
                System.out.println("  🎉 ¡" + turnoActual + " ha ganado la partida!");
                finalizado = true;

            } else if (tableroPartida.estaLleno()) {
                System.out.println("  🤝 ¡Tablero lleno! La partida termina en empate.");
                finalizado = true;

            } else {
                // Alternar turno entre los dos jugadores
                turnoActual = (turnoActual == jugador1) ? jugador2 : jugador1;
            }
        }
    }

    private int pedirColumna(Jugador jugador, Tablero t) {
        int col = -1;
        boolean valida = false;

        while (!valida) {
            System.out.print("  " + jugador + ", elige columna (1-" + t.getColumnas() + "): ");

            if (teclado.hasNextInt()) {
                int entrada = teclado.nextInt();
                col = entrada - 1; // Convertir a índice 0-based

                if (!estaEnRango(col, t.getColumnas())) {
                    System.out.println("  ⚠  Columna fuera de rango. Elige entre 1 y " + t.getColumnas() + ".");
                } else if (!t.columnaDisponible(col)) {
                    System.out.println("  ⚠  Esa columna está llena. Elige otra.");
                } else {
                    valida = true;
                }
            } else {
                System.out.println("  ⚠  Entrada inválida. Introduce un número.");
                teclado.next(); // Descartar token no numérico
            }
        }
        return col;
    }

    private boolean estaEnRango(int col, int totalColumnas) {
        return col >= 0 && col < totalColumnas;
    }

    private boolean preguntarRevancha() {
        System.out.print("\n¿Queréis jugar otra partida? (s/n): ");
        String respuesta = teclado.next().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
    }

    private void mostrarBienvenida() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      CONECTA CUATRO  🔴🟡    ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.printf ("║  Tablero: %2d filas x %2d cols ║%n",
                tablero.getFilas(), tablero.getColumnas());
        System.out.println("║  " + jugador1 + "             ║");
        System.out.println("║  " + jugador2 + "             ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println();
    }
}