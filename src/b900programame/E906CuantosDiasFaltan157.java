package b900programame;

import java.util.Scanner;

public class E906CuantosDiasFaltan157 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] diasMes = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int T = teclado.nextInt();

        while (T-- > 0) {
            int dia = teclado.nextInt();
            int mes = teclado.nextInt();

            int diaDelAnio = dia;

            for (int i = 0; i < mes - 1; i++) {
                diaDelAnio += diasMes[i];
            }
            System.out.println(365 - diaDelAnio);
        }
    }
}