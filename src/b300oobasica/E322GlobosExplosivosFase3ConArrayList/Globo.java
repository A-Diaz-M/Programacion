package b300oobasica.E322GlobosExplosivosFase3ConArrayList;

import java.util.Random;

public class Globo {

    private static final int MIN_CAPACIDAD = 10;
    private static final int MAX_CAPACIDAD = 100;

    private int capacidad;
    private int aire;

    public Globo() {
        this.capacidad = new Random().nextInt(MIN_CAPACIDAD, MAX_CAPACIDAD + 1);
        this.aire = 0;
    }

    public Globo(int capacidad) {
        this.capacidad = capacidad;
        this.aire = 0;
    }

    public void inflar(int cantidad) {
        aire += cantidad;
    }

    public boolean estaExplotado() {
        return aire > capacidad;
    }

    @Override
    public String toString() {
        StringBuilder globo = new StringBuilder();

        int aireMostrado = Math.min(aire, capacidad);

        for (int i = 0; i < aireMostrado; i++) {
            globo.append("*");
        }
        for (int i = aireMostrado; i < capacidad; i++) {
            globo.append("O");
        }

        return globo.toString();
    }
}