package b400ooavanz.E431GlobosDeDistintosTipos;

public class GloboFlexible extends Globo {

    private static final double MARGEN_EXTRA = 0.10; // 10 % por encima del nominal
    private static final double UMBRAL_SOPLO = 0.05; // soplo "suave": ≤ 5 % del nominal

    private int ultimoSoplo = 0;

    public GloboFlexible() {
        super();
    }

    public GloboFlexible(int valor) {
        super(valor);
    }

    @Override
    public void inflar(int cantidad) {
        aire += cantidad;
        ultimoSoplo = cantidad;
    }

    @Override
    public boolean explotado() {
        double limiteAbsoluto = capacidad * (1.0 + MARGEN_EXTRA);
        double umbralSoplo = capacidad * UMBRAL_SOPLO;

        if (aire > limiteAbsoluto) return true;  // Regla 1
        if (aire > capacidad && ultimoSoplo > umbralSoplo) return true;  // Regla 2
        return false;                                                        // Regla 3
    }
}