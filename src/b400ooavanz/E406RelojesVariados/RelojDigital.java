package b400ooavanz.E406RelojesVariados;

public class RelojDigital extends Reloj {

    public RelojDigital() {
        super();
    }

    public RelojDigital(int horas, int minutos) {
        super(horas, minutos);
    }

    public RelojDigital(int totalMinutos) {
        super(totalMinutos);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", horas, minutos);
    }

    @Override
    public RelojDigital clone() {
        return new RelojDigital(horas, minutos);
    }
}
