package b300oobasica.E325Frase;

public class Main {
    static void main(String[] args) {

        Frase f1 = new Frase(3, "hola");
        Frase f2 = new Frase("hola hola hola");

        System.out.println(f1);
        System.out.println(f1.caracterEn(0));
        System.out.println(f1.longitud());

        f1.anexar("qué tal");
        System.out.println(f1);

        f1.recortar(7);
        System.out.println(f1);

        System.out.println(f1.equals(f2));

        Frase f3 = f1.clone();
        System.out.println(f3);
    }
}