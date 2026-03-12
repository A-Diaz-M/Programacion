package b400ooavanz.E404RelojesComparables;

import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {
        int[] numeros = new int[] {7, 4, 2, 3, 1};
        Reloj[] relojes = new Reloj[] {new Reloj(17, 40), new Reloj(9, 20), new Reloj(7, 00)};

        Arrays.sort(numeros);
        Arrays.sort(relojes);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        System.out.println();
        for (int i = 0; i < relojes.length; i++) {
            System.out.println(relojes[i]);
        }
    }
}