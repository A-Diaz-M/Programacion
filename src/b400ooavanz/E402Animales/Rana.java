package b400ooavanz.E402Animales;

public class Rana extends Anfibio {

    @Override
    public void habla() {
        if (energia < 30) {
            System.out.println("croac...");
        } else if (energia < 70) {
            System.out.println("croac");
        } else {
            System.out.println("¡¡CROAC!!");
        }

        super.habla();
    }

    @Override
    public void come(int cantidadComida) {
        subirEnergia(cantidadComida * 6);
    }
}

