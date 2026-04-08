package b800varios.E828ContarDigitosPares;

public class Principal {
    public static int contarDigitosPares(int n) { // Ejemplo: 104
        if (n == 0) return 1;

        int demasDigitos = n / 10; // 10
        int digitoActual = n % 10; // 4

        int suma = 0;
        if (digitoActual % 2 == 0) suma = suma + 1;
        if (demasDigitos > 0) suma = suma + contarDigitosPares(demasDigitos);
        return suma;
    }

    public static void main(String[] args) {
        System.out.printf("0 tiene %d digito par\n", contarDigitosPares(0));
        System.out.printf("104 tiene %d digitos pares\n", contarDigitosPares(104));
        System.out.printf("1357 tiene %d digitos pares\n", contarDigitosPares(1357));
        System.out.printf("241638 tiene %d digitos pares\n", contarDigitosPares(241638));
    }
}