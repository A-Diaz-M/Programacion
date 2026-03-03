package b400ooavanz.E402Animales;

public class Gato extends Mamifero {

    public Gato() {
        super();
    }

    public Gato(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        if (energia < 30) {
            System.out.println("miauuuuuu...");
        } else if (energia < 70) {
            System.out.println("miau");
        } else {
            System.out.println("¡¡MIAU!!");
        }

        super.habla();
    }

    @Override
    public void come(int cantidadComida) {
        subirEnergia(cantidadComida * 12);
    }
}