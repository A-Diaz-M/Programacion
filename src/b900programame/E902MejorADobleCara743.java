package b900programame;

import java.util.Scanner;

public class E902MejorADobleCara743 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            int documentos = teclado.nextInt();
            if (documentos == 0) break;

            int ahorrados = 0;

            for (int i = 0; i < documentos; i++) {
                int caras = teclado.nextInt();
                int hojasDobleCara = (caras + 1) / 2;
                ahorrados += caras - hojasDobleCara;
            }
            System.out.println(ahorrados);
        }
    }
}