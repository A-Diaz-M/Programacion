package b800varios.E861ExcepcionesEnReloj;

public class Reloj {

    // ── Atributos ─────────────────────────────────────────────────────────────
    private int h;
    private int m;

    // ── Constructores ─────────────────────────────────────────────────────────
    public Reloj() {
        this(8, 15);
    }

    public Reloj(int h, int m) {
        this.h = h;
        this.m = m;
        normalizar(); // solo normaliza en el constructor (rango inicial válido)
    }

    public Reloj(int totalMinutos) {
        this(0, totalMinutos);
    }

    // ── Getters / Setters ─────────────────────────────────────────────────────
    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    // ── toString / equals / clone ─────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return (this.h == otro.h) && (this.m == otro.m);
    }

    public Reloj clone() {
        return new Reloj(this.h, this.m);
    }

    // ── Operaciones con excepciones ───────────────────────────────────────────

    public void tick()
            throws DesbordamientoRelojException, OperacionNegativaRelojException {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos)
            throws DesbordamientoRelojException, OperacionNegativaRelojException {

        if (minutos < 0)
            throw new OperacionNegativaRelojException(
                    "No puedes pasar un número negativo. Usa restarMinutos() en su lugar.");

        if (totalMinutos() + minutos >= 24 * 60)
            throw new DesbordamientoRelojException(
                    "La suma saldría del día (≥ 24:00).", true);

        m += minutos;
        normalizar();
    }

    public void restarMinutos(int minutos)
            throws DesbordamientoRelojException, OperacionNegativaRelojException {

        if (minutos < 0)
            throw new OperacionNegativaRelojException(
                    "No puedes pasar un número negativo. Usa sumarMinutos() en su lugar.");

        if (totalMinutos() - minutos < 0)
            throw new DesbordamientoRelojException(
                    "La resta saldría del día (< 00:00).", false);

        m -= minutos;
        normalizar();
    }

    // ── Métodos de consulta (sin excepciones) ─────────────────────────────────
    public int diferenciaMinutos(Reloj otro) {
        return Math.abs(this.totalMinutos() - otro.totalMinutos());
    }

    public Reloj diferenciaReloj(Reloj otro) {
        return new Reloj(this.diferenciaMinutos(otro));
    }

    // ── Privados ──────────────────────────────────────────────────────────────
    private void normalizar() {
        while (m < 0) {
            h--;
            m += 60;
        }
        while (m >= 60) {
            h++;
            m -= 60;
        }
        while (h < 0) {
            h += 24;
        }
        while (h >= 24) {
            h -= 24;
        }
    }

    private int totalMinutos() {
        return 60 * h + m;
    }
}