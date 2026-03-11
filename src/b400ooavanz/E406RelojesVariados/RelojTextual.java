package b400ooavanz.E406RelojesVariados;

/**
 * Reloj que expresa la hora en palabras.
 * Subclases concretas: RelojEspañol, RelojIngles.
 */
public abstract class RelojTextual extends Reloj {

    public RelojTextual() {
        super();
    }

    public RelojTextual(int horas, int minutos) {
        super(horas, minutos);
    }

    public RelojTextual(int totalMinutos) {
        super(totalMinutos);
    }

    /** Convierte un entero (0-59) en su representación textual. */
    protected abstract String numeroTexto(int n);

    /** Palabra para la unidad de horas (singular/plural). */
    protected abstract String palabraHora(int h);

    /** Palabra para la unidad de minutos (singular/plural). */
    protected abstract String palabraMinuto(int m);

    @Override
    public abstract String toString();
}
