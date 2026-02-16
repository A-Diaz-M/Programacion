package b300oobasica.E335BingoConMainCompleto;

import java.util.ArrayList;

public class Carton {
    private ArrayList<Integer> numeros;
    private ArrayList<Boolean> marcados;
    private int cantidadNumeros;
    private Bombo bombo;

    public Carton(int cantidadNumeros, Bombo bombo) {
        if (cantidadNumeros <= 0 || cantidadNumeros > bombo.getCantidadBolas()) {
            throw new IllegalArgumentException("Cantidad de números inválida");
        }

        this.cantidadNumeros = cantidadNumeros;
        this.bombo = bombo;
        numeros = new ArrayList<>();
        marcados = new ArrayList<>();
        numRandom();
    }

    public String toString() {
        StringBuilder numerosMarcados = new StringBuilder();

        for (int i = 0; i < numeros.size(); i++) {
            if (marcados.get(i)) {
                numerosMarcados.append(String.format("%4d*", numeros.get(i)));
            } else {
                numerosMarcados.append(String.format("%4d", numeros.get(i)));
            }
        }

        return numerosMarcados.toString();
    }

    private void numRandom() {
        int numero;
        for (int i = 0; i < cantidadNumeros; i++) {

            do {
                numero = (int) (Math.random() * bombo.getCantidadBolas()) + 1;
            } while (numeroExiste(numero));

            numeros.add(numero);
            marcados.add(false);
        }
    }

    private boolean numeroExiste(int numero) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i).equals(numero)) return true;
        }

        return false;
    }

    public void anotaBola(int bola) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i).equals(bola)) marcados.set(i, true);
        }
    }

    public boolean hayBingo() {
        for (int i = 0; i < numeros.size(); i++) {
            if (!marcados.get(i)) return false;
        }

        return true;
    }
}