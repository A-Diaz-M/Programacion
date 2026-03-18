package b400ooavanz.E410Animales;

public abstract class Mamifero extends Animal {
    public static final int GASTO_POR_HABLAR = 3;

    public Mamifero(int aprovechamientoComida, String nombre) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre);
    }

    public Mamifero(int aprovechamientoComida, String nombre, int energia) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre, energia);
    }
}