package b400ooavanz.E410Animales;

public class Hormiga extends Insecto {
    public static final int APROVECHAMIENTO_COMIDA = 4;

    public Hormiga(String nombre) {
        super(APROVECHAMIENTO_COMIDA, nombre);
    }

    public Hormiga(String nombre, int energia) {
        super(APROVECHAMIENTO_COMIDA, nombre, energia);
    }
}