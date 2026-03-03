package b400ooavanz.E402Animales;

public abstract class Ave extends Animal {

    public Ave() {
        super();
    }

    public Ave(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        bajarEnergia(2);
    }
}