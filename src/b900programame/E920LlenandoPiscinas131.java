package b900programame;

import java.util.Scanner;

public class E920LlenandoPiscinas131 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            int litrosPiscinaYo = entrada.nextInt();
            int litrosBarrenioYo = entrada.nextInt();
            int litrosPerdidosYo = entrada.nextInt();

            int litrosPiscinaVecino = entrada.nextInt();
            int litrosBarrenioVecino = entrada.nextInt();
            int litrosPerdidosVecino = entrada.nextInt();

            if (litrosPiscinaYo == 0 && litrosPiscinaVecino == 0) {
                break;
            }

            int capacidadYo = litrosBarrenioYo - litrosPerdidosYo;
            int capacidadVecino = litrosBarrenioVecino - litrosPerdidosVecino;

            int viajesYo = Integer.MAX_VALUE;
            int viajesVecino = Integer.MAX_VALUE;

            if (capacidadYo > 0) {
                viajesYo = litrosPiscinaYo / capacidadYo;
                if (litrosPiscinaYo % capacidadYo != 0) {
                    viajesYo++;
                }
            }

            if (capacidadVecino > 0) {
                viajesVecino = litrosPiscinaVecino / capacidadVecino;
                if (litrosPiscinaVecino % capacidadVecino != 0) {
                    viajesVecino++;
                }
            }

            if (viajesYo < viajesVecino) {
                System.out.println("YO " + viajesYo);
            } else if (viajesVecino < viajesYo) {
                System.out.println("VECINO " + viajesVecino);
            } else {
                System.out.println("EMPATE " + viajesYo);
            }
        }
    }
}