package b300oobasica.E365MotorDiesel;

public class CurvaParInterpolacion implements EstrategiaCurvaPar {

    // ── Puntos clave de la curva (deben estar ordenados por RPM) ─────────────
    private static final double[] RPMS = { 800,  1200, 2000,  3200,  4500 };
    private static final double[] PARES= { 100,  220,  350,   280,   50  };

    @Override
    public double calcularPar(double rpm) {
        // Fuera del rango operativo
        if (rpm < RPMS[0] || rpm > RPMS[RPMS.length - 1]) return 0.0;

        // Buscar el segmento en el que cae la RPM actual
        for (int i = 0; i < RPMS.length - 1; i++) {
            if (rpm >= RPMS[i] && rpm <= RPMS[i + 1]) {
                double rpm1 = RPMS[i],    rpm2 = RPMS[i + 1];
                double par1 = PARES[i],   par2 = PARES[i + 1];
                // Interpolación lineal
                return par1 + (rpm - rpm1) * (par2 - par1) / (rpm2 - rpm1);
            }
        }
        return 0.0;
    }
}
