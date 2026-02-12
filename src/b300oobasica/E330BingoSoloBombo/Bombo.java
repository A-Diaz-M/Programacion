package b300oobasica.E330BingoSoloBombo;

import java.util.Random;

public class Bombo {

    private boolean[] bolas;
    private int cantidadBolas;
    private Random random;

    public Bombo(int cantidadBolas) {
        this.cantidadBolas = cantidadBolas;
        this.bolas = new boolean[cantidadBolas + 1];
        this.random = new Random();

        for (int i = 1; i <= cantidadBolas; i++) {
            bolas[i] = true;
        }
    }

    public boolean bolaEstaDentro(int bola) {
        return bolas[bola];
    }

    public int dameBola() {
        int bola;

        do {
            bola = random.nextInt(cantidadBolas) + 1;
        } while (!bolas[bola]);

        bolas[bola] = false;
        return bola;
    }

    @Override
    public String toString() {
        StringBuilder dentro = new StringBuilder("Bolas dentro: ");
        StringBuilder fuera = new StringBuilder("Bolas fuera: ");

        for (int i = 1; i <= cantidadBolas; i++) {
            if (bolas[i]) {
                dentro.append(i).append(" ");
            } else {
                fuera.append(i).append(" ");
            }
        }
        return dentro.toString() + "\n" + fuera.toString();
    }
}