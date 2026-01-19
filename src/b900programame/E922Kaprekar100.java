package b900programame;

import java.util.Scanner;
import java.util.Arrays;

public class E922Kaprekar100 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numeroDeCasos = teclado.nextInt();

        for (int i = 0; i < numeroDeCasos; i++) {
            int num = teclado.nextInt();
            System.out.println(calcularIteracionesKaprekar(num));
        }
    }

    static int calcularIteracionesKaprekar(int num) {
        if (num == 6174) {
            return 0;
        }

        if (esNumeroRepdigit(num)) {
            return 8;
        }

        int numeroDeIteraciones = 0;

        while (num != 6174) {
            num = aplicarPasoKaprekar(num);
            numeroDeIteraciones++;
        }

        return numeroDeIteraciones;
    }

    static int aplicarPasoKaprekar(int num) {
        String numeroConCuatroDigitos = String.format("%04d", num);

        char[] digitos = numeroConCuatroDigitos.toCharArray();

        Arrays.sort(digitos);
        int numeroAscendente = Integer.parseInt(new String(digitos));

        String numeroDescendenteComoTexto = new StringBuilder(new String(digitos)).reverse().toString();
        int numeroDescendente = Integer.parseInt(numeroDescendenteComoTexto);

        return numeroDescendente - numeroAscendente;
    }

    static boolean esNumeroRepdigit(int num) {
        String numeroConCuatroDigitos = String.format("%04d", num);
        char primerDigito = numeroConCuatroDigitos.charAt(0);

        for (int i = 1; i < 4; i++) {
            if (numeroConCuatroDigitos.charAt(i) != primerDigito) {
                return false;
            }
        }
        return true;
    }
}