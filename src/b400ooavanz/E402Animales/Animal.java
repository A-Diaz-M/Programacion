package b400ooavanz.E402Animales;

public abstract class Animal {

    protected int energia;

    public Animal() {
        this.energia = 100;
    }

    public Animal(int energiaInicial) {
        if (energiaInicial < 0) {
            this.energia = 0;
        } else if (energiaInicial > 100) {
            this.energia = 100;
        } else {
            this.energia = energiaInicial;
        }
    }

    public abstract void habla();

    public abstract void come(int cantidadComida);

    protected void subirEnergia(int cantidad) {
        energia += cantidad;
        if (energia > 100) {
            energia = 100;
        }
    }

    protected void bajarEnergia(int cantidad) {
        energia -= cantidad;
        if (energia < 0) {
            energia = 0;
        }
    }

    public int getEnergia() {
        return energia;
    }
}
