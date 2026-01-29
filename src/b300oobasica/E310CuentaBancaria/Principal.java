package b300oobasica.E310CuentaBancaria;

public class Principal {
    static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta();

        cuenta1.ingresarCajero(5);
        cuenta1.extraerCajero(7);
        cuenta1.cargarRecibo();
    }
}
