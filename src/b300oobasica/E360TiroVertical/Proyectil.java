package b300oobasica.E360TiroVertical;

public class Proyectil {

    // ── Atributos privados ────────────────────────────────────────────────────
    private double altura;    // Posición actual en metros (eje Y)
    private double velocidad; // Velocidad actual en m/s

    // ── Constantes ────────────────────────────────────────────────────────────
    private static final double GRAVEDAD = -9.81; // Aceleración gravitatoria (m/s²)

    // ── Constructor ───────────────────────────────────────────────────────────
    public Proyectil(double velocidadInicial) {
        this.velocidad = velocidadInicial;
        this.altura    = 0.0;
    }

    // ── Motor físico ──────────────────────────────────────────────────────────
    public void actualizar(double deltaTiempo) {
        // Paso A: la gravedad modifica la velocidad
        velocidad += GRAVEDAD * deltaTiempo;
        // Paso B: la velocidad modifica la posición
        altura    += velocidad * deltaTiempo;
    }

    // ── Getters ───────────────────────────────────────────────────────────────
    public double getAltura()    { return altura;    }
    public double getVelocidad() { return velocidad; }
}
