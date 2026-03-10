package b200algoritmica.E231TresEnRayaCasiOO;

public class Tablero {
    private static int[][] matriz = new int[3][3];
    private static int jugadorActual = 1;

    public static void dibujar() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (matriz[i][j] == 0) {
                    System.out.print(". ");
                } else if (matriz[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    public static void marcar(int fil, int col) {
        matriz[fil][col] = jugadorActual;
    }

    public static int getJugadorActual() {
        return jugadorActual;
    }

    public static void alternarJugador() {
        jugadorActual = 3 - jugadorActual;
    }

    public static int buscarGanador() {

        if (matriz[0][0] != 0 && matriz[0][0] == matriz[0][1] && matriz[0][1] == matriz[0][2])
            return matriz[0][0];

        if (matriz[1][0] != 0 && matriz[1][0] == matriz[1][1] && matriz[1][1] == matriz[1][2])
            return matriz[1][0];

        if (matriz[2][0] != 0 && matriz[2][0] == matriz[2][1] && matriz[2][1] == matriz[2][2])
            return matriz[2][0];

        if (matriz[0][0] != 0 && matriz[0][0] == matriz[1][0] && matriz[1][0] == matriz[2][0])
            return matriz[0][0];

        if (matriz[0][1] != 0 && matriz[0][1] == matriz[1][1] && matriz[1][1] == matriz[2][1])
            return matriz[0][1];

        if (matriz[0][2] != 0 && matriz[0][2] == matriz[1][2] && matriz[1][2] == matriz[2][2])
            return matriz[0][2];

        if (matriz[0][0] != 0 && matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2])
            return matriz[0][0];

        if (matriz[0][2] != 0 && matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0])
            return matriz[0][2];

        boolean lleno = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (matriz[i][j] == 0) {
                    lleno = false;
                }
            }
        }
        if (lleno)
            return 0;
        return -1;
    }
}