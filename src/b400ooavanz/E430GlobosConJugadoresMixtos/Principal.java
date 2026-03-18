package b400ooavanz.E430GlobosConJugadoresMixtos;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();

        // ── Cambia las líneas de abajo para elegir la combinación que quieras ──
        // HH → dos humanos
        // jugadores.add(new JugadorHumano("J1"));
        // jugadores.add(new JugadorHumano("J2"));

        // HC → humano vs cpu  (configuración por defecto)
        jugadores.add(new JugadorHumano("J1-Humano"));
        jugadores.add(new JugadorCpu("J2-CPU"));

        // CH → cpu primero
        // jugadores.add(new JugadorCpu("J1-CPU"));
        // jugadores.add(new JugadorHumano("J2-Humano"));

        // CC → dos cpus
        // jugadores.add(new JugadorCpu("CPU-1"));
        // jugadores.add(new JugadorCpu("CPU-2"));

        // N jugadores → simplemente añade más:
        // jugadores.add(new JugadorHumano("J3-Humano"));
        // jugadores.add(new JugadorCpu("J4-CPU"));
        // ─────────────────────────────────────────────────────────────────────

        Juego juego = new Juego(jugadores);
        juego.empezar();
    }
}
