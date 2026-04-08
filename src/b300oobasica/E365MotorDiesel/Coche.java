package b300oobasica.E365MotorDiesel;

public class Coche {

    // ── Constantes físicas ────────────────────────────────────────────────────
    private static final double MASA              = 1400.0; // kg
    private static final double RESISTENCIA_BASE  = 50.0;   // N (rozamiento + aire simplificado)
    private static final double FACTOR_VEL_RPM    = 100.0;

    // ── Estado ────────────────────────────────────────────────────────────────
    private double      velocidadActual; // m/s
    private MotorDiesel motor;

    // ── Constructor ───────────────────────────────────────────────────────────
    public Coche(EstrategiaCurvaPar estrategia) {
        this.motor           = new MotorDiesel(estrategia);
        this.velocidadActual = 0.0;
    }

    // ── Delegación al motor ───────────────────────────────────────────────────
    public void encender()                   { motor.encender(); }
    public void apagar()                     { motor.apagar();   }
    public void setAcelerador(double pos)    { motor.setAcelerador(pos); }
    public double getRpm()                   { return motor.getRpm(); }

    // ── Bucle físico ──────────────────────────────────────────────────────────
    public void actualizar(double deltaTiempo) {
        if (!motor.isEncendido()) return;

        // 1. Fuerza de empuje = par generado (simplificación pedagógica)
        double fEmpuje      = motor.getParGeneradoActual();

        // 2. Resistencia al avance
        double fResistencia = RESISTENCIA_BASE;

        // 3. Segunda Ley de Newton → aceleración lineal
        double aceleracion  = (fEmpuje - fResistencia) / MASA;

        // 4. Integración de Euler → velocidad nueva
        velocidadActual += aceleracion * deltaTiempo;
        if (velocidadActual < 0.0) velocidadActual = 0.0; // el coche no retrocede

        // 5. Vínculo dinámico: velocidad → RPM
        double rpmPorVelocidad = velocidadActual * FACTOR_VEL_RPM;
        motor.setRpm(rpmPorVelocidad);

        // 6. El motor sigue actualizando su estado interno con las RPM vinculadas
        motor.actualizar(deltaTiempo);
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public double getVelocidad() { return velocidadActual; }
    public double getVelocidadKmh() { return velocidadActual * 3.6; }
}