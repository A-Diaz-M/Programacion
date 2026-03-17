package b400ooavanz.E420InterfazParlante;

public abstract class Insecto extends Animal {
    public static final int GASTO_POR_HABLAR = 1;

    public Insecto(int aprovechamientoComida, String nombre) {
        super(aprovechamientoComida, GASTO_POR_HABLAR, nombre);
    }
}