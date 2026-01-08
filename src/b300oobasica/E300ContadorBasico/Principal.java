package b300oobasica.E300ContadorBasico;

public class Principal {
    static void main(String[] args) {
        Contador c = new Contador();
        c.incrementar(150);
        IO.println(c.getValor());

        c.decrementar(500);
        IO.println(c.getValor());

        c.setValor(180);
        IO.println(c.getValor());

        c.setValor(-180);
        IO.println(c.getValor());
    }
}