package b200algoritmica.E238ConectaCuatro;

public class Tablero {
    private static final int CONECTA = 4; // Número de fichas seguidas para ganar

    private final int filas;
    private final int columnas;

    private final int[][] celdas;

    private final int[] fichasPorColumna;


    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new int[filas][columnas];
        this.fichasPorColumna = new int[columnas]; // Java inicializa a 0
    }


    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    // Devuelve true si la columna (0-based) es válida y no está llena.
    public boolean columnaDisponible(int col) {
        return col >= 0 && col < columnas && fichasPorColumna[col] < filas;
    }

    // Devuelve true si todas las celdas están ocupadas.
    public boolean estaLleno() {
        for (int c = 0; c < columnas; c++) {
            if (fichasPorColumna[c] < filas) return false;
        }
        return true;
    }

    public int colocarFicha(int col, Jugador jugador) {
        if (!columnaDisponible(col)) return -1;

        // La ficha cae sobre las ya existentes: desde abajo (fila máxima)
        int fila = filas - 1 - fichasPorColumna[col];
        celdas[fila][col] = jugador.getNumero();
        fichasPorColumna[col]++;
        return fila;
    }

    public boolean hayVictoria(int fila, int col, Jugador jugador) {
        return comprobarEje(fila, col, jugador, 1, 0)   // Vertical      ↓↑
                || comprobarEje(fila, col, jugador, 0, 1)   // Horizontal    ←→
                || comprobarEje(fila, col, jugador, 1, 1)   // Diagonal  \   ↘↖
                || comprobarEje(fila, col, jugador, 1, -1);  // Diagonal  /   ↙↗
    }

    private boolean comprobarEje(int fila, int col, Jugador jugador, int dFila, int dCol) {
        int total = 1
                + contarEnDireccion(fila, col, jugador, dFila, dCol)
                + contarEnDireccion(fila, col, jugador, -dFila, -dCol);
        return total >= CONECTA;
    }

    private int contarEnDireccion(int fila, int col, Jugador jugador, int dFila, int dCol) {
        int cuenta = 0;
        int f = fila + dFila;
        int c = col + dCol;

        while (f >= 0 && f < filas && c >= 0 && c < columnas
                && celdas[f][c] == jugador.getNumero()) {
            cuenta++;
            f += dFila;
            c += dCol;
        }
        return cuenta;
    }

    public void mostrar(Jugador j1, Jugador j2) {
        System.out.println();

        // Cabecera con números de columna (1-based para el usuario)
        System.out.print(" ");
        for (int c = 1; c <= columnas; c++) System.out.printf(" %d ", c);
        System.out.println();

        // Línea superior
        imprimirSeparador();

        // Filas
        for (int f = 0; f < filas; f++) {
            System.out.print("|");
            for (int c = 0; c < columnas; c++) {
                if (celdas[f][c] == j1.getNumero()) System.out.print(j1.getSimbolo());
                else if (celdas[f][c] == j2.getNumero()) System.out.print(j2.getSimbolo());
                else System.out.print(" . ");
            }
            System.out.println("|");
        }

        // Línea inferior
        imprimirSeparador();
        System.out.println();
    }

    private void imprimirSeparador() {
        System.out.print("+");
        for (int c = 0; c < columnas; c++) System.out.print("---");
        System.out.println("+");
    }
}