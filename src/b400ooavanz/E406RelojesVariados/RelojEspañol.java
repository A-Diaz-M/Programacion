package b400ooavanz.E406RelojesVariados;

public class RelojEspañol extends RelojTextual {

    // Unidades y decenas especiales (0-29 directos)
    private static final String[] UNIDADES = {
        "cero", "una", "dos", "tres", "cuatro", "cinco", "seis", "siete",
        "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince",
        "dieciséis", "diecisiete", "dieciocho", "diecinueve",
        "veinte", "veintiún", "veintidós", "veintitrés", "veinticuatro",
        "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"
    };

    private static final String[] DECENAS = {
        "", "", "veinte", "treinta", "cuarenta", "cincuenta"
    };

    // Unidades para minutos (masculino: "un minuto")
    private static final String[] UNIDADES_M = {
        "cero", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete",
        "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince",
        "dieciséis", "diecisiete", "dieciocho", "diecinueve",
        "veinte", "veintiún", "veintidós", "veintitrés", "veinticuatro",
        "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"
    };

    // ── Constructores ──────────────────────────────────────────────────────────

    public RelojEspañol() { super(); }

    public RelojEspañol(int horas, int minutos) { super(horas, minutos); }

    public RelojEspañol(int totalMinutos) { super(totalMinutos); }

    // ── Helpers ────────────────────────────────────────────────────────────────

    /** Número en español (femenino: "una", "veintiún"). Rango 0-23. */
    @Override
    protected String numeroTexto(int n) {
        if (n < 30) return UNIDADES[n];
        // 30-59
        int dec = n / 10;
        int uni = n % 10;
        return DECENAS[dec] + (uni != 0 ? " y " + UNIDADES[uni] : "");
    }

    /** Número en español (masculino: "un"). Rango 0-59. */
    private String numeroTextoMasc(int n) {
        if (n < 30) return UNIDADES_M[n];
        int dec = n / 10;
        int uni = n % 10;
        return DECENAS[dec] + (uni != 0 ? " y " + UNIDADES_M[uni] : "");
    }

    @Override
    protected String palabraHora(int h) {
        return h == 1 ? "hora" : "horas";
    }

    @Override
    protected String palabraMinuto(int m) {
        return m == 1 ? "minuto" : "minutos";
    }

    @Override
    public String toString() {
        // Usamos hora en formato 24h tal como está almacenada
        String txtHoras   = numeroTexto(horas);
        String txtMinutos = numeroTextoMasc(minutos);
        return txtHoras + " " + palabraHora(horas)
             + ", " + txtMinutos + " " + palabraMinuto(minutos);
    }

    @Override
    public RelojEspañol clone() {
        return new RelojEspañol(horas, minutos);
    }
}
