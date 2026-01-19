package b900programame;

import java.util.Scanner;

public class E920LlenandoPiscinas131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long p = sc.nextLong();
            long b = sc.nextLong();
            long l = sc.nextLong();
            long pv = sc.nextLong();
            long bv = sc.nextLong();
            long lv = sc.nextLong();

            // Fin de entrada
            if (p == 0 || pv == 0) break;

            long viajesYo, viajesVecino;

            long gananciaYo = b - l;
            if (gananciaYo <= 0) {
                viajesYo = Long.MAX_VALUE;
            } else {
                viajesYo = (p + gananciaYo - 1) / gananciaYo;
            }

            long gananciaVecino = bv - lv;
            if (gananciaVecino <= 0) {
                viajesVecino = Long.MAX_VALUE;
            } else {
                viajesVecino = (pv + gananciaVecino - 1) / gananciaVecino;
            }

            if (viajesYo < viajesVecino) {
                System.out.println("YO " + viajesYo);
            } else if (viajesVecino < viajesYo) {
                System.out.println("VECINO " + viajesVecino);
            } else {
                System.out.println("EMPATE " + viajesYo);
            }
        }

        sc.close();
    }
}