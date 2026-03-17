package b300oobasica.E315TresEnRayaOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Tablero tablero = new Tablero();

        do {
            tablero.dibujar();

            System.out.format("J%d: Introduzca coordenadas:\n", tablero.getJugadorActual());
            System.out.print("Fila: ");
            int fil = teclado.nextInt();
            System.out.print("Columna: ");
            int col = teclado.nextInt();

            tablero.marcar(fil, col);

            tablero.alternarJugador();
        } while (tablero.buscarGanador() == -1);

        tablero.dibujar();

        System.out.println(switch (tablero.buscarGanador()) {
            case 0 -> "Ha quedado en tablas.";
            case 1 -> "Ha ganado el J1.";
            case 2 -> "Ha ganado el J2.";
            default -> "Ouch. Error. Nunca deberíamos llegar aquí :'(";
        });
    }
}
