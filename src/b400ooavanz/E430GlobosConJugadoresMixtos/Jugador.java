package b400ooavanz.E430GlobosConJugadoresMixtos;

public abstract class Jugador {
    public static final int SOPLO_MAX_ABSOLUTO = 10;
    public static final int SOPLO_MAXIMO_ACUMULADO = 11;

    private String nombre;
    private int rondasGanadas;
    private int aireTotalSoplado;
    private int maxSoploEstaRonda;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.rondasGanadas = 0;
        this.aireTotalSoplado = 0;
        this.maxSoploEstaRonda = SOPLO_MAX_ABSOLUTO;  // empieza sin cansancio
    }

    public abstract int determinarSoplo();

    public void registrarSoplo(int soplo) {
        aireTotalSoplado += soplo;
        // Cansancio: máximo para la siguiente ronda = ACUMULADO - lo que soplé ahora
        maxSoploEstaRonda = SOPLO_MAXIMO_ACUMULADO - soplo;
        if (maxSoploEstaRonda < 1) maxSoploEstaRonda = 1;  // mínimo siempre 1
    }

    public void resetearCansancio() {
        maxSoploEstaRonda = SOPLO_MAX_ABSOLUTO;
    }

    public void ganarRonda() {
        rondasGanadas++;
    }

    public String getNombre() { return nombre; }
    public int getRondasGanadas() { return rondasGanadas; }
    public int getAireTotalSoplado() { return aireTotalSoplado; }
    public int getMaxSoploEstaRonda() { return maxSoploEstaRonda; }

    @Override
    public String toString() {
        return nombre;
    }
}
