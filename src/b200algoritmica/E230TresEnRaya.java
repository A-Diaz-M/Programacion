package b200algoritmica;

import java.util.Scanner;

public class E230TresEnRaya {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] tablero = new int[3][3];
        int turno = 1;
        boolean ganador = false;

        while (!ganador) {
            System.out.println();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tablero[i][j] == 0) {
                        System.out.print(". ");
                    } else if (tablero[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }

            if (turno == 1) {
                System.out.println("Turno jugador 1 (X)");
            } else {
                System.out.println("Turno jugador 2 (O)");
            }

            System.out.print("Fila (1-3): ");
            int fila = sc.nextInt() - 1;

            System.out.print("Columna (1-3): ");
            int columna = sc.nextInt() - 1;

            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                System.out.println("Posición inválida, intenta otra vez.");
                continue;
            }

            tablero[fila][columna] = turno;

            if (
                    (tablero[0][0] != 0 && tablero[0][0] == tablero[0][1] && tablero[0][1] == tablero[0][2]) ||
                            (tablero[1][0] != 0 && tablero[1][0] == tablero[1][1] && tablero[1][1] == tablero[1][2]) ||
                            (tablero[2][0] != 0 && tablero[2][0] == tablero[2][1] && tablero[2][1] == tablero[2][2]) ||

                            (tablero[0][0] != 0 && tablero[0][0] == tablero[1][0] && tablero[1][0] == tablero[2][0]) ||
                            (tablero[0][1] != 0 && tablero[0][1] == tablero[1][1] && tablero[1][1] == tablero[2][1]) ||
                            (tablero[0][2] != 0 && tablero[0][2] == tablero[1][2] && tablero[1][2] == tablero[2][2]) ||

                            (tablero[0][0] != 0 && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) ||
                            (tablero[0][2] != 0 && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])
            ) {
                ganador = true;
            }
            turno = 3 - turno;
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (tablero[i][j] == 0) {
                    System.out.print(". ");
                } else if (tablero[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }

            }
            System.out.println();
        }
        turno = 3 - turno;

        if (turno == 1) {
            System.out.println("Gana el jugador 1 (X)");
        } else {
            System.out.println("Gana el jugador 2 (O)");
        }

    }
}