package b300oobasica.E303NumeroInteligenteBasico;

public class Principal {
    static void main(String[] args) {
        NumeroInteligente n1 = new NumeroInteligente();

        for (int i = 1; i <= 100; i++) {
            n1.setValor(i);
            if (n1.esPrimo()) {
                IO.println(n1.getValor() + " es primo.");
            } else {
                IO.println(n1.getValor() + " no es primo.");
            }
        }
        IO.println();

        NumeroInteligente n2 = new NumeroInteligente();

        int num = 0;

        while (num < 100) {
            if (n2.esPrimo()) {
                IO.println(n2.getValor() + " es primo.");
                num++;
            }
            n2.incrementar();
        }

        IO.println();

        NumeroInteligente n3 = new NumeroInteligente();

        IO.println("Mediante la formula de Euclides se va a sacar el numero perfecto usando en ella el numero primo de mersenne.");
        for (int i = 1; i <= 13; i++) {
            n3.setValor(i);
            if (n3.esPerfecto()) {
                IO.println(String.format("Con el nùmero número: %d, tienes: %d, Perfecto.", i, n3.getNumeroPerfecto()));
            }
        }
    }
}