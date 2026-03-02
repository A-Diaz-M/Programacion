package Examen24Feb.E03_NumeroAbundante;

public class E03_NumeroAbundante {

    public static boolean esNumeroAbundante(int num) {
        int suma = 0;

        for (int i = 1; i < num - 1; i++) {
            if (num % i == 0) suma += i;
        }

        if (suma <= num) return false;
        return true;
    }


    static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (esNumeroAbundante(i)) {
                System.out.println(i);
            }
        }
    }
}