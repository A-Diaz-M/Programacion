package b400ooavanz.E430GlobosConJugadoresMixtos;

public class Globo {
    private static final int CAP_MIN = 10;
    private static final int CAP_MAX = 50;

    private int capacidadMax;
    private int aireActual;

    public Globo() {
        this.capacidadMax = CAP_MIN + (int)(Math.random() * (CAP_MAX - CAP_MIN + 1));
        this.aireActual = 0;
    }

    public void inflar(int cantidad) {
        aireActual += cantidad;
    }

    public boolean haExplotado() {
        return aireActual > capacidadMax;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public int getAireActual() {
        return aireActual;
    }

    @Override
    public String toString() {
        if (haExplotado()) {
            return "[" + "!".repeat(capacidadMax) + "] ¡BOOM!";
        }
        return "[" + "*".repeat(aireActual) + ".".repeat(capacidadMax - aireActual) + "]"
                + " (" + aireActual + "/" + capacidadMax + ")";
    }
}
