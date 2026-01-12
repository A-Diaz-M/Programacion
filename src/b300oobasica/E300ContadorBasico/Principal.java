package b300oobasica.E300ContadorBasico;

public class Principal {
    static void main(String[] args) {
        Contador c = new Contador(7,"balones");
        c.incrementar(1);
        c.incrementar(1);
        c.decrementar(1);
        c.decrementar();
        IO.println(c);

        Contador c2 = new Contador();
        c2.incrementar(1);
        c2.incrementar(1);
        c2.incrementar();
        c2.decrementar(1);
        IO.println(c2);

        c2.resetear();
        IO.println(c2);
    }
}