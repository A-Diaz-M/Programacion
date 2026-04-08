package b300oobasica.E365MotorDiesel;

public class SimulacionDiesel {

    private static final double DELTA_TIEMPO        = 0.1;   // s
    private static final double DURACION_TOTAL      = 15.0;  // s
    private static final double TIEMPO_SOLTAR_GAS   = 10.0;  // s
    private static final double POSICION_ACELERADOR = 0.80;  // 80 %

    public static void main(String[] args) {

        // ── Usamos la estrategia de parábola (la más suave y realista) ────────
        Coche coche = new Coche(new CurvaParParabola());

        coche.encender();
        coche.setAcelerador(POSICION_ACELERADOR);

        System.out.println("=".repeat(65));
        System.out.println("  SIMULACIÓN VEHÍCULO DIÉSEL  –  Δt = " + DELTA_TIEMPO + " s");
        System.out.println("=".repeat(65));
        System.out.printf("%-10s %-14s %-14s %-10s%n",
                "Tiempo(s)", "Vel. (m/s)", "Vel. (km/h)", "RPM");
        System.out.println("-".repeat(65));

        double tiempo = 0.0;
        int    paso   = 0;

        while (tiempo <= DURACION_TOTAL + 1e-9) {

            // Soltar el acelerador a los 10 s
            if (tiempo >= TIEMPO_SOLTAR_GAS && paso == (int)(TIEMPO_SOLTAR_GAS / DELTA_TIEMPO)) {
                coche.setAcelerador(0.0);
                System.out.println();
                System.out.println("  *** ACELERADOR → 0.0 (freno motor activo) ***");
                System.out.println();
            }

            // Imprimir estado cada iteración
            System.out.printf("%-10.1f %-14.3f %-14.3f %-10.1f%n",
                    tiempo,
                    coche.getVelocidad(),
                    coche.getVelocidadKmh(),
                    coche.getRpm());

            // Avanzar simulación
            coche.actualizar(DELTA_TIEMPO);
            tiempo = Math.round((tiempo + DELTA_TIEMPO) * 1000.0) / 1000.0;
            paso++;
        }

        System.out.println("=".repeat(65));
        System.out.printf("  FIN – Velocidad final: %.3f m/s (%.2f km/h) | RPM: %.1f%n",
                coche.getVelocidad(),
                coche.getVelocidadKmh(),
                coche.getRpm());
        System.out.println("=".repeat(65));
    }
}
