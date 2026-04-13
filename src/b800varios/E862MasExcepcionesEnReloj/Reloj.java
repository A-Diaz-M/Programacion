package b800varios.E862MasExcepcionesEnReloj;

public class Reloj {

    private int h;
    private int m;

    public Reloj() throws HoraNoValidaException, MinutoNoValidoException {
        this(8, 15);
    }

    public Reloj(int h, int m) throws HoraNoValidaException, MinutoNoValidoException {
        // Validamos ANTES de asignar. Importante: primero horas, luego minutos,
        // para que el catch del main pueda informar del campo concreto que falló.
        if (h < 0 || h > 23) throw new HoraNoValidaException(h);
        if (m < 0 || m > 59) throw new MinutoNoValidoException(m);

        this.h = h;
        this.m = m;
    }

    public Reloj(int totalMinutos) throws DesbordamientoRelojException {
        if (totalMinutos < 0) {
            // Exceso = cuántos minutos por debajo de 0
            throw new DesbordamientoRelojException(false, Math.abs(totalMinutos));
        }
        if (totalMinutos >= 24 * 60) {
            // Exceso = cuántos minutos por encima de 23:59
            throw new DesbordamientoRelojException(true, totalMinutos - (24 * 60 - 1));
        }

        this.h = totalMinutos / 60;
        this.m = totalMinutos % 60;
    }

    public int getH() { return h; }
    public void setH(int h) { this.h = h; }
    public int getM() { return m; }
    public void setM(int m) { this.m = m; }

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    public boolean equals(Object obj) {
        if (obj == null)             return false;
        if (!(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return (this.h == otro.h) && (this.m == otro.m);
    }

    public Reloj clone() {
        try {
            return new Reloj(this.h, this.m);
        } catch (HoraNoValidaException | MinutoNoValidoException e) {
            return null; // nunca llegará aquí: h y m ya son valores válidos
        }
    }

    public void tick() throws OperacionNegativaRelojException, DesbordamientoRelojException {
        sumar(1);
    }

    public void sumar(int minutos) throws OperacionNegativaRelojException, DesbordamientoRelojException {
        if (minutos < 0) throw new OperacionNegativaRelojException();

        int resultado = totalMinutos() + minutos;
        if (resultado >= 24 * 60)
            throw new DesbordamientoRelojException(true, resultado - (24 * 60 - 1));

        m += minutos;
        normalizar();
    }

    public void restar(int minutos) throws DesbordamientoRelojException, OperacionNegativaRelojException {
        if (minutos < 0) throw new OperacionNegativaRelojException();

        int resultado = totalMinutos() - minutos;
        if (resultado < 0)
            throw new DesbordamientoRelojException(false, Math.abs(resultado));

        m -= minutos;
        normalizar();
    }

    private void normalizar() {
        while (m <   0) { h--; m += 60; }
        while (m >= 60) { h++; m -= 60; }
        while (h <   0) { h += 24; }
        while (h >= 24) { h -= 24; }
    }

    private int totalMinutos() {
        return 60 * h + m;
    }
}