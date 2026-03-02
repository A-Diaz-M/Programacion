package Examen24Feb.E05_Fibo;

public class Fibo {
    public int anterior = 0;
    public int actual = 1;
    public int contador = 0;

    public int obtenerSiguiente() {
        if (contador == 0) {
            contador++;
            return 0;
        } else if (contador == 1) {
            contador++;
            return 1;
        }
        int siguiente = anterior + actual;
        anterior = actual;
        actual = siguiente;
        return actual;
    }
}