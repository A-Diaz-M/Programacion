package b300oobasica.E360TiroVertical;

public class SimuladorProyectil {

    private static final double VELOCIDAD_INICIAL = 60.0; // m/s

    public static void main(String[] args) {

        // ── Tres Delta Times a comparar ───────────────────────────────────────
        double[] deltasTiempo = { 1.0, 0.1, 0.01 };

        for (double dt : deltasTiempo) {
            System.out.println("=".repeat(60));
            System.out.printf("  SIMULACIÓN  –  Delta Time = %.2f s%n", dt);
            System.out.println("=".repeat(60));
            System.out.printf("%-12s %-15s %-15s%n", "Tiempo (s)", "Altura (m)", "Velocidad (m/s)");
            System.out.println("-".repeat(45));

            Proyectil proyectil   = new Proyectil(VELOCIDAD_INICIAL);
            double    tiempoTotal = 0.0;

            // Imprimimos estado inicial
            imprimirEstado(tiempoTotal, proyectil);

            // Bucle principal: simula mientras el proyectil esté en el aire
            while (proyectil.getAltura() >= 0.0) {
                proyectil.actualizar(dt);
                tiempoTotal += dt;
                imprimirEstado(tiempoTotal, proyectil);
            }

            System.out.printf("%nImpacto: t = %.4f s | altura = %.4f m | velocidad = %.4f m/s%n%n",
                    tiempoTotal,
                    proyectil.getAltura(),
                    proyectil.getVelocidad());
        }

        // ── Valores teóricos de referencia ────────────────────────────────────
        double g         = 9.81;
        double tVuelo    = 2.0 * VELOCIDAD_INICIAL / g;
        double vImpacto  = -VELOCIDAD_INICIAL;
        System.out.println("=".repeat(60));
        System.out.println("  SOLUCIÓN ANALÍTICA EXACTA (referencia teórica)");
        System.out.println("=".repeat(60));
        System.out.printf("  t_vuelo   = 2·v0/g  = %.4f s%n", tVuelo);
        System.out.printf("  v_impacto = -v0     = %.4f m/s%n", vImpacto);
    }

    // ── Auxiliar de impresión ─────────────────────────────────────────────────
    private static void imprimirEstado(double tiempo, Proyectil p) {
        System.out.printf("%-12.4f %-15.4f %-15.4f%n",
                tiempo, p.getAltura(), p.getVelocidad());
    }
}
