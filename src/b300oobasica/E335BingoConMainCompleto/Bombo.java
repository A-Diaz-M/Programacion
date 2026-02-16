package b300oobasica.E335BingoConMainCompleto;

public class Bombo {
    private int cantidadBolas;
    private boolean[] bolas;

    public Bombo(int cantidadBolas) {
        this.cantidadBolas = cantidadBolas;
        bolas = new boolean[cantidadBolas + 1];

        for (int i = 1; i <= cantidadBolas; i++) {
            bolas[i] = true;
        }
    }

    public String toString() {
        StringBuilder dentro = new StringBuilder("Dentro: ");
        StringBuilder fuera = new StringBuilder("Fuera: ");

        for (int i = 1; i < bolas.length; i++) {
            (bolas[i] ? dentro : fuera).append(i + " ");
        }

        return dentro + "\n" + fuera;
    }

    public int getCantidadBolas() {
        return cantidadBolas;
    }

    public int dameBola() {
        int bola;
        do {
            bola = (int) (Math.random() * cantidadBolas + 1);
        } while (!bolaEstaDentro(bola));

        bolas[bola] = false;
        return bola;
    }

    public boolean bolaEstaDentro(int bola) {
        if (bola < 1 || bola > cantidadBolas) {
            return false;
        }

        return bolas[bola];
    }
}