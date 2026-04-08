package b800varios.E322GlobosExplosivosFase3ConArrayList;

public class Globo {
    private int capacidadMaxima;
    private int cantidadAire;

    public Globo() {
        capacidadMaxima = (int) (Math.random() * 41) + 10;
        cantidadAire = 0;
    }

    public Globo(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        cantidadAire = 0;
    }

    public void inflar(int cantidad) {
        cantidadAire = cantidadAire + cantidad;
    }

    public String toString() {
        String dibujo = "";

        for (int i = 0; i < cantidadAire; i++) {
            dibujo = dibujo + "*";
        }

        for (int i = 0; i < capacidadMaxima - cantidadAire; i++) {
            dibujo = dibujo + "O";
        }
        return dibujo;
    }

    public boolean estaExplotado() {
        if (cantidadAire > capacidadMaxima) return true;
        return false;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadAire() {
        return cantidadAire;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {

        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCantidadAire(int cantidadAire) {
        this.cantidadAire = cantidadAire;
    }
}