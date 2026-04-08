package b800varios.E822SumaTotal;

import java.util.Scanner;

public class Principal {
    private static int sumaTotal(int n) {
        if (n == 0) return 0;
        else return n + sumaTotal(n - 1);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Vamos a calcular la suma total desde 1 hasta el número que digas a continuación:");
        int numeroHasta = teclado.nextInt();

        System.out.printf("El resultado es %d.\n", sumaTotal(numeroHasta));
    }
}