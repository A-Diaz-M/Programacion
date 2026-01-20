package b300oobasica.E302ContadorCompletoEqualsClone;

public class Principal {
    static void main(String[] args) {
        Contador a = new Contador(7);
        Contador b = new Contador(5);
        Contador c = a.clone();

        System.out.println(a);
        System.out.println(b);

        if (a.equals(a)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        if (a.equals(b)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        if (a.equals(c)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        c.incrementar(10);

        if (a.equals(c)) {
            System.out.println("Iguales");
        } else {
            System.out.println("Distintos");
        }

        System.out.println(a);
        System.out.println(c);
    }
}