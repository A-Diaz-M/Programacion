package b200algoritmica.E238ConectaCuatro;

public class Jugador {

    private final int numero;    // 1 o 2 (es el valor que se guarda en la matriz)
    private final String nombre;
    private final String simbolo; // "[X]" o "[O]"

    public Jugador(int numero, String nombre, String simbolo) {
        this.numero = numero;
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return nombre + " (" + simbolo + ")";
    }
}