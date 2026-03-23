package b400ooavanz.E431GlobosDeDistintosTipos;

import java.util.Random;

public abstract class Globo {

    public static final int RANDOM_MIN = 10;
    public static final int RANDOM_MAX = 50;

    protected int capacidad;
    protected int aire = 0;

    public Globo() {
        this.capacidad = new Random().nextInt(RANDOM_MIN, RANDOM_MAX + 1);
    }

    public Globo(int capacidad) {
        this.capacidad = capacidad;
    }

    public abstract void inflar(int cantidad);

    public abstract boolean explotado();

    public int getCapacidad() {
        return capacidad;
    }

    public int getAire() {
        return aire;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getClass().getSimpleName())
                .append("|cap:").append(capacidad).append("] ");

        for (int i = 0; (i < aire) && (i < capacidad); i++) sb.append("*");
        for (int i = aire; i < capacidad; i++) sb.append("O");
        for (int i = capacidad; i < aire; i++) sb.append("!");

        return sb.toString();
    }
}