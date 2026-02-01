package b300oobasica.E312CuentaBancariaConInt;

public class Cuenta implements Cloneable {

    private int saldo;
    private final int descubiertoMaximo;

    public Cuenta(double saldoInicial) {
        this.saldo = (int) Math.round(saldoInicial * 100);
        this.descubiertoMaximo = 0;
    }

    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        this.saldo = (int) Math.round(saldoInicial * 100);
        this.descubiertoMaximo = (int) Math.round(descubiertoMaximo * 100);
    }

    public void ingresarCajero(double cantidad) {
        int centimos = (int) Math.round(cantidad * 100);
        saldo += centimos;
    }

    public void extraerCajero(double cantidad) {
        int centimos = (int) Math.round(cantidad * 100);
        if (saldo - centimos < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo -= centimos;
    }

    public void cargarRecibo(double cantidad) {
        int centimos = (int) Math.round(cantidad * 100);
        if (saldo - centimos < -descubiertoMaximo) {
            throw new RuntimeException("Descubierto máximo superado");
        }
        saldo -= centimos;
    }

    @Override
    public String toString() {
        return "Cuenta saldo = " + (saldo / 100.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)) return false;
        Cuenta otra = (Cuenta) obj;
        return this.saldo == otra.saldo;
    }

    @Override
    public Cuenta clone() {
        return new Cuenta(this.saldo / 100.0, this.descubiertoMaximo / 100.0);
    }
}
