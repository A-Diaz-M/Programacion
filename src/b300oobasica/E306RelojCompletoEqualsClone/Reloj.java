package b300oobasica.E306RelojCompletoEqualsClone;

public class Reloj {
    private int totalMinutos;

    public Reloj() {
        this(8, 15);
    }

    public Reloj(int horas, int min) {
        this(horas * 60 + min);
    }

    public Reloj(int totalMinutos) {
        setTotalMinutos(totalMinutos);
        normalizar();
    }

    public int getHoras() {
        return totalMinutos / 60;
    }

    public int getMin() {
        return totalMinutos % 60;
    }

    public void setTotalMinutos(int totalMinutos) {
        this.totalMinutos = totalMinutos;
    }

    public String toString() {
        return String.format("%02d:%02d", getHoras(), getMin());
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Reloj)) return false;

        Reloj otro = (Reloj) obj;
        return this.totalMinutos == otro.totalMinutos;
    }

    public Reloj clone() {
        return new Reloj(this.totalMinutos);
    }

    private void normalizar() {
        totalMinutos = totalMinutos % 1440;

        if (totalMinutos < 0) {
            totalMinutos += 1440;
        }
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int minutos) {
        setTotalMinutos(totalMinutos += minutos);
        normalizar();
    }

    public void restarMinutos(int minutos) {
        setTotalMinutos(totalMinutos -= minutos);
        normalizar();
    }

    public int diferenciaMinutos(Reloj otro) {
        return Math.abs(this.totalMinutos - otro.totalMinutos);
    }

    public Reloj diferenciaReloj(Reloj otro) {
        return new Reloj(this.diferenciaMinutos(otro));
    }
}