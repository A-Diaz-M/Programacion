package b300oobasica.E300ContadorBasico;

public class Principal {
    static void main(String[] args) {
        Contador c = new Contador(23000);
        c.incrementar(1);
        c.incrementar(1);
        c.decrementar(1);
        IO.println(c);

        Contador c2 = new Contador();
        c2.incrementar(1);
        c2.incrementar(1);
        c2.decrementar(1);
        IO.println(c2.getValor());
    }
}