package b300oobasica.E305RelojHMBasico;

public class Reloj {
    private int horas;
    private int minutos;

    public Reloj() {
        conversor(495);
    }

    public Reloj(int totalMinutos) {
        conversor(totalMinutos);
    }

    public Reloj(int h, int m) {
        conversor((h * 60) + m);
    }

    public void conversor(int minutosTotales) {
        horas = minutosTotales / 60;
        minutos = minutosTotales % 60;
    }

    @Override
    public String toString() {
        return String.format("Formato 24h: %02d:%02d", horas, minutos);
    }

    public Reloj clone() {
        return new Reloj(this.horas, this.minutos);
    }

    public boolean equals(Object obj){
        if(obj == null) return false;

        if (!(obj instanceof Reloj)) return false;

        Reloj otro = (Reloj) obj;
        return ((this.horas == otro.horas) && (this.minutos == otro.minutos));
    }

    public void tick() {
        sumarMinutos(1);
    }

    public void sumarMinutos(int m) {
        int totalMinutos = horas * 60 + minutos;
        totalMinutos += m;

        totalMinutos = totalMinutos % 1440;

        conversor(totalMinutos);
    }

    public void restarMinutos(int m) {
        int totalMinutos = horas * 60 + minutos;
        totalMinutos -= m;

        totalMinutos = ((totalMinutos % 1440) + 1440) % 1440;

        conversor(totalMinutos);
    }

    public int diferenciaMinutos(Reloj reloj) {
        int thisMinutos = horas * 60 + minutos;
        int otroMinutos = reloj.horas * 60 + reloj.minutos;

        return Math.abs(thisMinutos - otroMinutos);
    }

    public Reloj diferenciaReloj(Reloj reloj) {
        int totalDif = Math.abs(diferenciaMinutos(reloj));
        int difHoras = totalDif / 60;
        int difMinutos = totalDif % 60;
        return new Reloj(difHoras, difMinutos);
    }
}