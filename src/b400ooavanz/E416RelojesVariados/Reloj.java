package b400ooavanz.E416RelojesVariados;

public abstract class Reloj {

    protected int horas;
    protected int minutos;

    public Reloj() {
        this(8, 15);
    }

    public Reloj(int horas, int minutos) {
        setTiempo(horas, minutos);
    }

    public Reloj(int totalMinutos) {
        setTotalMinutos(totalMinutos);
    }

    public int getHoras()   { return horas; }
    public int getMinutos() { return minutos; }

    protected void setTotalMinutos(int total) {
        total = total % 1440;
        if (total < 0) total += 1440;
        this.horas   = total / 60;
        this.minutos = total % 60;
    }

    private void setTiempo(int h, int m) {
        setTotalMinutos(h * 60 + m);
    }

    @Override
    public abstract String toString();

    @Override
    public abstract Reloj clone();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Reloj)) return false;
        Reloj otro = (Reloj) obj;
        return this.horas == otro.horas && this.minutos == otro.minutos;
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int mins) {
        setTiempo(horas, minutos + mins);
    }

    public void restarMinutos(int mins) {
        sumarMinutos(-mins);
    }

    public int diferenciaMinutos(Reloj otro) {
        int thisTotal = this.horas * 60 + this.minutos;
        int otroTotal = otro.horas  * 60 + otro.minutos;
        return Math.abs(thisTotal - otroTotal);
    }

    public Reloj diferenciaReloj(Reloj otro) {
        Reloj r = this.clone();
        r.setTotalMinutos(this.diferenciaMinutos(otro));
        return r;
    }
}