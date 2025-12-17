package b900programame;

import java.util.Scanner;

public class E903MejorADobleCara743 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            int documentos = teclado.nextInt();
            if (documentos == 0) break;

            int ahorrados = 0;

            for (int i = 0; i < documentos; i++) {
                int caras = teclado.nextInt();
                ahorrados += caras / 2;
            }
            System.out.println(ahorrados);
        }
    }
}