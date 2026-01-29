package b300oobasica.E310CuentaBancaria;

public class Cuenta {

    private static final int MIN = 0;

    private double saldo = 0.0;
    private double descubierto = 0.0;

    public Cuenta() {

    }

    public Cuenta(int valor, int descubierto) {

    }

    public void ingresarCajero (double valor) {
        this.saldo += valor;
    }

    public void extraerCajero(double valor) {
        if (this.saldo < valor) throw new RuntimeException("No puedes extraer mas cantidad de la que tienes.");
    }

    public void cargarRecibo(double valor) {
        this.saldo -= valor;
        if (this.saldo < 0) descubierto = this.saldo;
        this.saldo = 0;
    }
}