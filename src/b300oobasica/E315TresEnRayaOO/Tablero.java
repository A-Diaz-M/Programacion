package b300oobasica.E315TresEnRayaOO;

public class Tablero {
    private int[][] matriz = new int[3][3];
    private int jugadorActual = 1;

    public Tablero() {

    }

    public void dibujar() {
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

    public void marcar(int fil, int col) {
        matriz[fil][col] = jugadorActual;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public void alternarJugador() {
        jugadorActual = 3 - jugadorActual;
    }

    public int buscarGanador() {

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