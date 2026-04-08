package b300oobasica.E365MotorDiesel;

public class CurvaParParabola implements EstrategiaCurvaPar {

    private static final double H = 2500.0;    // RPM de par máximo
    private static final double K = 350.0;     // Par máximo (Nm)
    private static final double A = -0.000022; // Apertura de la parábola

    private static final double RPM_MIN = 800.0;
    private static final double RPM_MAX = 4500.0;

    @Override
    public double calcularPar(double rpm) {
        if (rpm < RPM_MIN || rpm > RPM_MAX) return 0.0;
        double par = A * Math.pow(rpm - H, 2) + K;
        // El par nunca puede ser negativo dentro del rango operativo
        return Math.max(par, 0.0);
    }
}