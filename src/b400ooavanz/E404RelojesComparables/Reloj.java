package b400ooavanz.E404RelojesComparables;

public class Reloj implements Comparable<Reloj> {
    private int h;
    private int m;

    public Reloj() {
       this(8, 15);
    }

    public Reloj(int h, int m) {
        this.h = h;
        this.m = m;
        normalizar();
    }

    public Reloj(int totalMinutos) {
        this(0, totalMinutos);
    }

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

    public String toString() {
        return String.format("%02d:%02d", h, m);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return ((this.h == otro.h) && (this.m == otro.m));
    }

    public Reloj clone() {
        Reloj clon = new Reloj();
        clon.h = this.h;
        clon.m = this.m;
        return clon;
    }

    private void normalizar() {
        while (m <   0) { h--; m = m + 60; }
        while (m >= 60) { h++; m = m - 60; }

        while (h <   0) { h = h + 24; }
        while (h >= 24) { h = h - 24; }
    }

    private int totalMinutos() {
        return 60 * h + m;
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos) {
        m = m + minutos;
        normalizar();
    }

    public void restarMinutos(int minutos) {
        m = m - minutos;
        normalizar();
    }

    public int diferenciaMinutos(Reloj otro) {
        int diferencia = Math.abs(this.totalMinutos() - otro.totalMinutos());
        return diferencia;
    }

    public Reloj diferenciaReloj(Reloj otro) {
        int diferenciaMinutos = this.diferenciaMinutos(otro);
        Reloj diferenciaReloj = new Reloj(diferenciaMinutos);
        return diferenciaReloj;
    }

    @Override
    public int compareTo(Reloj otro) {
        return this.totalMinutos() - otro.totalMinutos();
    }
}