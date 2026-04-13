package b900programame;

import java.util.Scanner;

public class E916Telegramas637 {

    // Tabla Morse: índices 0-25 = A-Z, 26 = '!', 27 = '?'
    private static final String[] MORSE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",   // A-I
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", // J-R
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", // S-Z
            "-.-.--",  // !
            "..--.."   // ?
    };

    private static String morseOf(char c) {
        if (c >= 'A' && c <= 'Z') return MORSE[c - 'A'];
        if (c == '!') return MORSE[26];
        if (c == '?') return MORSE[27];
        return "";
    }

    // Duración de una letra: suma de símbolos + pausas internas (1 punto entre símbolos)
    private static int duracionLetra(String morse) {
        int total = 0;
        for (int i = 0; i < morse.length(); i++) {
            total += (morse.charAt(i) == '-') ? 3 : 1; // raya=3, punto=1
            if (i < morse.length() - 1) total += 1;    // pausa entre símbolos
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();

        while (casos-- > 0) {
            String linea = sc.nextLine();
            String[] palabras = linea.split(" ");

            int total = 0;

            for (int p = 0; p < palabras.length; p++) {
                String palabra = palabras[p];

                for (int l = 0; l < palabra.length(); l++) {
                    total += duracionLetra(morseOf(palabra.charAt(l)));

                    // Pausa entre letras dentro de la misma palabra
                    if (l < palabra.length() - 1) total += 3;
                }

                // Pausa entre palabras
                if (p < palabras.length - 1) total += 5;
            }

            System.out.println(total);
        }

        sc.close();
    }
}