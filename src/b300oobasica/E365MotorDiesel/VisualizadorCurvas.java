package b300oobasica.E365MotorDiesel;

public class VisualizadorCurvas {

    private static final int    SALTO_RPM  = 100;
    private static final int    ANCHO_BARRA = 50;  // asteriscos para 350 Nm (máx esperado)
    private static final double PAR_MAXIMO  = 350.0;

    public static void main(String[] args) {

        EstrategiaCurvaPar[] estrategias = {
            new CurvaParTramos(),
            new CurvaParInterpolacion(),
            new CurvaParParabola()
        };
        String[] nombres = {
            "TRAMOS FIJOS      ",
            "INTERPOLACIÓN LIN.",
            "PARÁBOLA INVERTIDA"
        };

        for (int e = 0; e < estrategias.length; e++) {
            System.out.println("=".repeat(70));
            System.out.println("  Estrategia: " + nombres[e]);
            System.out.println("=".repeat(70));
            System.out.printf("%-8s %-8s %s%n", "RPM", "Par(Nm)", "Gráfica");
            System.out.println("-".repeat(70));

            for (int rpm = 800; rpm <= 4500; rpm += SALTO_RPM) {
                double par = estrategias[e].calcularPar(rpm);
                int asteriscos = (int) Math.round((par / PAR_MAXIMO) * ANCHO_BARRA);
                String barra = "*".repeat(Math.max(0, asteriscos));
                System.out.printf("%-8d %-8.1f |%s%n", rpm, par, barra);
            }
            System.out.println();
        }
    }
}
