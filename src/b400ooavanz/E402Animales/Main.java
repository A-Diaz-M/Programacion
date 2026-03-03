package b400ooavanz.E402Animales;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Animal> animales = new ArrayList<>();

        animales.add(new Perro(80));
        animales.add(new Gato(50));
        animales.add(new Pajaro(60));

        animales.add(new Perro(40));

        animales.add(new Rana());

        while (true) {

            for (Animal a : animales) {
                if (Math.random() < 0.30) {
                    int comida = (int) (Math.random() * 3) + 1; // entre 1 y 3
                    a.come(comida);
                }
                a.habla();
            }
            System.out.println();
            Thread.sleep(1000);
        }
    }
}