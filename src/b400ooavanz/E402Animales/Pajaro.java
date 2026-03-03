package b400ooavanz.E402Animales;

public class Pajaro extends Ave {

    public Pajaro() {
        super();
    }

    public Pajaro(int energiaInicial) {
        super(energiaInicial);
    }

    @Override
    public void habla() {
        if (energia < 30) {
            System.out.println("pio...");
        } else if (energia < 70) {
            System.out.println("pio pio");
        } else {
            System.out.println("¡¡PIO PIO!!");
        }

        super.habla();
    }

    @Override
    public void come(int cantidadComida) {
        subirEnergia(cantidadComida * 5);
    }
}