package Examen24Feb.E05_Fibo;

public class PrincipalFibo {
    static void main(String[] args) {
        Fibo fibo = new Fibo();

        System.out.println(fibo.obtenerSiguiente()); // Imprime 0
        System.out.println(fibo.obtenerSiguiente()); // Imprime 1
        System.out.println(fibo.obtenerSiguiente()); // Imprime 1
        System.out.println(fibo.obtenerSiguiente()); // Imprime 2
        System.out.println(fibo.obtenerSiguiente()); // Imprime 3
        System.out.println(fibo.obtenerSiguiente()); // Imprime 5
        System.out.println(fibo.obtenerSiguiente()); // Imprime 8
    }
}