package b900programame;

import java.util.Scanner;

public class E970JardinesAlhambra769 {

    static char[][] mapa;
    static int filas, cols;

    // Flood fill iterativo (pila explícita para evitar StackOverflow)
    static void rellenar(int f, int c) {
        int[] pf = new int[filas * cols];
        int[] pc = new int[filas * cols];
        int top = 0;

        mapa[f][c] = '.'; // marcar visitado antes de meter en pila
        pf[top] = f;
        pc[top] = c;
        top++;

        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (top > 0) {
            top--;
            int rf = pf[top];
            int rc = pc[top];

            for (int d = 0; d < 4; d++) {
                int nf = rf + df[d];
                int nc = rc + dc[d];
                if (nf >= 0 && nf < filas && nc >= 0 && nc < cols && mapa[nf][nc] == '#') {
                    mapa[nf][nc] = '.'; // marcar antes de apilar (evita duplicados)
                    pf[top] = nf;
                    pc[top] = nc;
                    top++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            filas = sc.nextInt();
            cols = sc.nextInt();
            mapa = new char[filas][cols];

            for (int i = 0; i < filas; i++)
                mapa[i] = sc.next().toCharArray();

            int cortacespedes = 0;

            for (int i = 0; i < filas; i++)
                for (int j = 0; j < cols; j++)
                    if (mapa[i][j] == '#') {
                        rellenar(i, j);
                        cortacespedes++;
                    }

            System.out.println(cortacespedes);
        }

        sc.close();
    }
}
