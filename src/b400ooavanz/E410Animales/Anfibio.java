package b400ooavanz.E410Animales;

public abstract class Anfibio extends Animal {
    public static final int GASTO_POR_HABLAR = 7;

    public Anfibio(int aprovechamientoComida, String nombre) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre);
    }

    public Anfibio(int aprovechamientoComida, String nombre, int energia) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre, energia);
    }
}