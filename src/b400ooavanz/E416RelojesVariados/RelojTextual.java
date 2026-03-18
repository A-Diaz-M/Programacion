package b400ooavanz.E416RelojesVariados;

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

    protected abstract String numeroTexto(int n);

    protected abstract String palabraHora(int h);

    protected abstract String palabraMinuto(int m);

    @Override
    public abstract String toString();
}
