package b400ooavanz.E406RelojesVariados;

import java.util.Arrays;

/**
 * Reloj analogico ASCII en formato:
 *
 *   \  |  /
 *    \ | /
 *   -- · --
 *    / | \
 *   /  |  \
 *
 *  Grid 5 filas x 7 columnas.
 *  8 direcciones (N, NE, E, SE, S, SW, W, NW).
 *
 *  - Manecilla de HORAS  -> posicion INTERIOR (cerca del centro) en AZUL
 *  - Manecilla de MINUTOS-> posicion EXTERIOR (lejos del centro)  en ROJO
 *
 *  Cada direccion equivale a 1.5h (horas) o 7.5 min (minutos).
 *  Se redondea al valor mas proximo.
 */
public class RelojAnalogico extends Reloj {

    private static final String BLUE  = "\033[94m";
    private static final String RED   = "\033[91m";
    private static final String RESET = "\033[0m";

    /**
     * 8 direcciones en sentido horario desde N.
     * Cada fila: { innerRow, innerCol, innerChar, outerRow, outerCol, outerChar }
     */
    private static final int[][] DIRS = {
        {1, 3, '|',  0, 3, '|'},   // 0: N   (12h / 0min)
        {1, 5, '/',  0, 6, '/'},   // 1: NE  (~1.5h / 7.5min)
        {2, 5, '-',  2, 6, '-'},   // 2: E   (3h / 15min)
        {3, 5, '\\', 4, 6, '\\'},  // 3: SE  (~4.5h / 22.5min)
        {3, 3, '|',  4, 3, '|'},   // 4: S   (6h / 30min)
        {3, 1, '/',  4, 0, '/'},   // 5: SW  (~7.5h / 37.5min)
        {2, 1, '-',  2, 0, '-'},   // 6: W   (9h / 45min)
        {1, 1, '\\', 0, 0, '\\'}   // 7: NW  (~10.5h / 52.5min)
    };

    // Constructores
    public RelojAnalogico() { super(); }
    public RelojAnalogico(int h, int m) { super(h, m); }
    public RelojAnalogico(int totalMinutos) { super(totalMinutos); }

    @Override
    public String toString() {
        String[][] g = new String[5][7];
        for (String[] fila : g) Arrays.fill(fila, " ");

        // Centro
        g[2][3] = "\u00b7";  // ·

        // Manecilla de HORAS (azul) -> posicion interior
        int hDir = (int) Math.round(((horas % 12) * 8.0) / 12) % 8;
        g[DIRS[hDir][0]][DIRS[hDir][1]] = BLUE + (char) DIRS[hDir][2] + RESET;

        // Manecilla de MINUTOS (rojo) -> posicion exterior
        int mDir = (int) Math.round((minutos * 8.0) / 60) % 8;
        g[DIRS[mDir][3]][DIRS[mDir][4]] = RED + (char) DIRS[mDir][5] + RESET;

        String marco = "+---------+";
        StringBuilder sb = new StringBuilder();
        sb.append(marco).append('\n');
        for (int r = 0; r < 5; r++) {
            sb.append("| ");
            for (int c = 0; c < 7; c++) sb.append(g[r][c]);
            sb.append(" |").append('\n');
        }
        sb.append(marco);
        return sb.toString();
    }

    @Override
    public RelojAnalogico clone() {
        return new RelojAnalogico(horas, minutos);
    }
}
