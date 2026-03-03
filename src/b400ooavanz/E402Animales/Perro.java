package b400ooavanz.E402Animales;

public class Perro extends Mamifero {

    public Perro() {
        super();
    }

    public Perro(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        if (energia < 30) {
            System.out.println("guau...");
        } else if (energia < 70) {
            System.out.println("guau");
        } else {
            System.out.println("¡¡GUAU!!");
        }

        super.habla();
    }

    @Override
    public void come(int cantidadComida) {
        subirEnergia(cantidadComida * 7);
    }
}