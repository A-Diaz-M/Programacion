package b900programame;

import java.util.Scanner;

public class E902HigosRobados788 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int casos = teclado.nextInt();
        int higosManola = 1;
        for (int i = 0; i < casos; i++) {
            int personas = teclado.nextInt();
            int higos = teclado.nextInt();
            int resto = higos % personas;
            higosManola = (higos / personas) + resto;
            System.out.println(higosManola);
        }
    }
}