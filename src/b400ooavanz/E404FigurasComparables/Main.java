package b400ooavanz.E404FigurasComparables;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[]{7, 4, 2, 3, 1};
        Figura[] figuras = new Figura[3];
        figuras[0] = new Circulo(8.27);
        figuras[1] = new Rectangulo(7.1, 5.0);
        figuras[2] = new Cuadrado(10.0);

        Arrays.sort(numeros);
        Arrays.sort(figuras);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        System.out.println();
        for (int i = 0; i < figuras.length; i++) {
            System.out.println(figuras[i]);
        }
    }
}