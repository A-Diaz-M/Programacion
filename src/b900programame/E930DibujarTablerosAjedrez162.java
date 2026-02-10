package b900programame;

import java.util.*;

public class E930DibujarTablerosAjedrez162 {
    static void dibujarLineaHorizontal(int ancho) {
        System.out.print("|");
        for (int i = 0; i < ancho; i++) {
            System.out.print("-");
        }
        System.out.println("|");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int tamanoEscaque = entrada.nextInt();

        while (tamanoEscaque != 0) {
            char caracterNegro = entrada.next().charAt(0);

            int ladoTablero = 8 * tamanoEscaque;

            dibujarLineaHorizontal(ladoTablero);

            for (int filaEscaque = 0; filaEscaque < 8; filaEscaque++) {
                for (int filaInterna = 0; filaInterna < tamanoEscaque; filaInterna++) {
                    System.out.print("|");
                    for (int columnaEscaque = 0; columnaEscaque < 8; columnaEscaque++) {
                        boolean escaqueEsNegro = (filaEscaque + columnaEscaque) % 2 == 1;
                        char relleno = escaqueEsNegro ? caracterNegro : ' ';
                        for (int columnaInterna = 0; columnaInterna < tamanoEscaque; columnaInterna++) {
                            System.out.print(relleno);
                        }
                    }
                    System.out.println("|");
                }
            }
            dibujarLineaHorizontal(ladoTablero);

            tamanoEscaque = entrada.nextInt();
        }
    }
}