package b300oobasica.E304ContadorConMinMaxConfigurables;

public class Principal {
    static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador(77);
        Contador c3 = new Contador(77, 5, 0, 50);
        Contador c4 = new Contador(77, 5, true);

        IO.println("c1");
        System.out.println(c1);
        IO.println("c2");
        System.out.println(c2);
        IO.println("c3");
        System.out.println(c3);
        IO.println("c4");
        System.out.println(c4);

        IO.println("c4");
        c4.incrementar();
        System.out.println(c4);

        IO.println("c4");
        c4.decrementar();
        System.out.println(c4);
    }
}