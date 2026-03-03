package b400ooavanz.E402Animales;

public abstract class Mamifero extends Animal {

    public Mamifero() {
        super();
    }

    public Mamifero(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        bajarEnergia(5);
    }
}