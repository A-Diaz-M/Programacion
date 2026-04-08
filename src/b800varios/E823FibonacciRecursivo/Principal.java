package b800varios.E823FibonacciRecursivo;

public class Principal {
    public static int obtenerValorFibonacci(int posicion) {
        if (posicion == 1) return 0;
        else if (posicion == 2) return 1;
        else return obtenerValorFibonacci(posicion - 2) + obtenerValorFibonacci(posicion - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("El número %d de la sucesión de Fibonacci es:\n%,d.", n, obtenerValorFibonacci(n));
    }
}