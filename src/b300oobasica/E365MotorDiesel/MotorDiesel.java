package b300oobasica.E365MotorDiesel;

public class MotorDiesel {

    // ── Constantes físicas ────────────────────────────────────────────────────
    private static final double INERCIA_MOTOR  = 0.2;   // kg·m² (resistencia al cambio de RPM)
    private static final double FRICCION_BASE  = 20.0;  // Nm  (pérdidas internas constantes)
    private static final double RPM_RALENTI    = 800.0; // RPM mínimas con motor encendido
    private static final double RPM_MAXIMAS    = 4500.0;

    // ── Estado interno ────────────────────────────────────────────────────────
    private double             rpmActuales;
    private double             acelerador;   // 0.0 → 1.0
    private boolean            encendido;
    private EstrategiaCurvaPar estrategia;

    // ── Constructor ───────────────────────────────────────────────────────────
    public MotorDiesel(EstrategiaCurvaPar estrategia) {
        this.estrategia  = estrategia;
        this.rpmActuales = 0.0;
        this.acelerador  = 0.0;
        this.encendido   = false;
    }

    // ── Interfaz pública ──────────────────────────────────────────────────────
    public void encender() {
        encendido    = true;
        rpmActuales  = RPM_RALENTI;
    }

    public void apagar() {
        encendido    = false;
        rpmActuales  = 0.0;
    }

    public void setAcelerador(double posicion) {
        // Clamp entre 0.0 y 1.0
        this.acelerador = Math.max(0.0, Math.min(1.0, posicion));
    }

    // ── Bucle físico (integración de Euler) ───────────────────────────────────
    public void actualizar(double deltaTiempo) {
        if (!encendido) return;

        // Paso A
        double parDisponible = estrategia.calcularPar(rpmActuales);

        // Paso B
        double parGenerado   = parDisponible * acelerador;

        // Paso C
        double friccionTotal = FRICCION_BASE;

        // Paso D
        double parNeto       = parGenerado - friccionTotal;

        // Paso E
        double aceleracionRpm = parNeto / INERCIA_MOTOR;

        // Paso F
        double rpmNuevas = rpmActuales + (aceleracionRpm * deltaTiempo);

        // Paso G
        rpmActuales = Math.max(RPM_RALENTI, Math.min(RPM_MAXIMAS, rpmNuevas));
    }

    public void setRpm(double rpm) {
        if (!encendido) return;
        rpmActuales = Math.max(RPM_RALENTI, Math.min(RPM_MAXIMAS, rpm));
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public double  getRpm()        { return rpmActuales; }
    public boolean isEncendido()   { return encendido;   }

    public double getParGeneradoActual() {
        double parDisponible = estrategia.calcularPar(rpmActuales);
        return parDisponible * acelerador;
    }
}