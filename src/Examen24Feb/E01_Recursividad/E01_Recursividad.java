package Examen24Feb.E01_Recursividad;

public class E01_Recursividad {

    public static int contarDigitosPares(int num) {
        if (num == 0) return 1;

        int digito = num % 10;
        int cuenta = (digito % 2 == 0) ? 1 : 0;

        if (num / 10 == 0) return cuenta;
        return cuenta + contarDigitosPares(num / 10);
    }

    static void main(String[] args) {
        System.out.println("241638 → " + contarDigitosPares(241638));
        System.out.println("1357 → " + contarDigitosPares(1357));
        System.out.println("104 → " + contarDigitosPares(104));
        System.out.println("0 → " + contarDigitosPares(0));
        System.out.println("8 → " + contarDigitosPares(8));
        System.out.println("77 → " + contarDigitosPares(77));
    }
}