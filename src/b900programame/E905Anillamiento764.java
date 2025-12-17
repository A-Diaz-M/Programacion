package b900programame;

import java.util.Scanner;

public class E905Anillamiento764 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int campanna;

        while (true) {
            campanna = teclado.nextInt();
            if (campanna == 0) break;

            int totales = 0;

            for (int i = 0; i < campanna; i++) {
                int capt = teclado.nextInt();
                int reg  = teclado.nextInt();
                totales += (capt - reg);
            }
            System.out.println(totales);
        }
    }
}