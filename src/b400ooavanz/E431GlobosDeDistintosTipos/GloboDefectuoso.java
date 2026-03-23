package b400ooavanz.E431GlobosDeDistintosTipos;

public class GloboDefectuoso extends Globo {

    private static final double UMBRAL = 0.6;   // 60% de la capacidad
    private static final double RANGO = 0.4;   // tramo del 60 % al 100 %

    private boolean haExplotado = false;

    public GloboDefectuoso() {
        super();
    }

    public GloboDefectuoso(int valor) {
        super(valor);
    }

    @Override
    public void inflar(int cantidad) {
        aire += cantidad;

        double porcentajeCapacidadNominal = (double) aire / capacidad;

        if (porcentajeCapacidadNominal <= UMBRAL) {
            // Zona segura: por debajo del 60 %.
            return;
        }

        if (porcentajeCapacidadNominal >= 1.0) {
            // Superado el 100 %: explota siempre.
            haExplotado = true;
            return;
        }

        // Entre 60 % y 100 %: interpolación lineal.
        // Cuánto del camino restante (0.0 → 1.0) hemos recorrido.
        double porcentajeCaminoRestante = (porcentajeCapacidadNominal - UMBRAL) / RANGO;

        // Si el random cae por debajo de la probabilidad → explota.
        haExplotado = (Math.random() < porcentajeCaminoRestante);
    }

    @Override
    public boolean explotado() {
        return haExplotado;
    }
}