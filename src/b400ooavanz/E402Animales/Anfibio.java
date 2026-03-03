package b400ooavanz.E402Animales;

public abstract class Anfibio extends Animal {

    public Anfibio() {
        super();
    }

    public Anfibio(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        bajarEnergia(3); // coste intermedio
    }
}