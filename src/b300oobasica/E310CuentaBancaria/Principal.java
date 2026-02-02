package b300oobasica.E310CuentaBancaria;

public class Principal {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(50);
        Cuenta cuenta2 = new Cuenta(50, 70);

        cuenta1.ingresarCajero(20);
        System.out.println(cuenta1);

        cuenta1.extraerCajero(70);
        System.out.println(cuenta1);

        try {
            cuenta1.extraerCajero(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        cuenta2.cargarRecibo(100);
        System.out.println(cuenta2);

        try {
            cuenta2.cargarRecibo(30);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(cuenta1.equals(cuenta2));

        Cuenta copia = cuenta2.clone();
        System.out.println("Copia: " + copia);
    }
}