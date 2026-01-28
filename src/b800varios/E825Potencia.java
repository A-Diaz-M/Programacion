package b800varios;

public class E825Potencia {

    public static int potencia(int n, int m) {
        if (m == 0) return 1;

        return n * potencia(n, m - 1);
    }

    static void main(String[] args) {
        System.out.println((potencia(2, 4)));
    }
}