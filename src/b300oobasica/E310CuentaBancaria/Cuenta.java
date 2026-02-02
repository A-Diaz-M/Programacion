package b300oobasica.E310CuentaBancaria;

public class Cuenta implements Cloneable {

    private double saldo;
    private final double descubiertoMaximo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
        this.descubiertoMaximo = 0;
    }

    public Cuenta(double saldoInicial, double descubiertoMaximo) {
        this.saldo = saldoInicial;
        this.descubiertoMaximo = descubiertoMaximo;
    }

    public void ingresarCajero(double cantidad) {
        saldo += cantidad;
    }

    public void extraerCajero(double cantidad) {
        if ((saldo - cantidad) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo -= cantidad;
    }

    public void cargarRecibo(double cantidad) {
        if ((saldo - cantidad) < -descubiertoMaximo) {
            throw new RuntimeException("Descubierto máximo superado");
        }
        saldo -= cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta saldo = " + saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cuenta)) return false;
        Cuenta otra = (Cuenta) obj;
        return this.saldo == otra.saldo;
    }

    @Override
    public Cuenta clone() {
        return new Cuenta(this.saldo, this.descubiertoMaximo);
    }
}