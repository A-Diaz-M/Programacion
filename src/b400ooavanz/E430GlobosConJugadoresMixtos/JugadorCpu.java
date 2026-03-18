package b400ooavanz.E430GlobosConJugadoresMixtos;

public class JugadorCpu extends Jugador {

    public JugadorCpu(String nombre) {
        super(nombre);
    }

    @Override
    public int determinarSoplo() {
        int max = getMaxSoploEstaRonda();
        int soplo = 1 + (int)(Math.random() * max);
        System.out.println(getNombre() + " (CPU) sopla: " + soplo);
        return soplo;
    }
}
