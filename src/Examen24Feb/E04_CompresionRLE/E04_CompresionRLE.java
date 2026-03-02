package Examen24Feb.E04_CompresionRLE;

public class E04_CompresionRLE {
    public static String comprimirTexto(String texto) {
        String palabraNueva;
        String laPalabra = "";
        int contador = 1;
        int contador2 = 0;
        for (int i = 0; i < texto.length() - 1; i++) {
            if (texto.charAt(i) == texto.charAt(i + 1)) {
                contador++;
            } else {
                palabraNueva = String.valueOf(texto.charAt(i - (contador - 1))) + contador;
                contador = 1;
                laPalabra = laPalabra + palabraNueva;
            }
            contador2++;
        }
        palabraNueva = String.valueOf(texto.charAt(contador2 - (contador - 1))) + contador;
        laPalabra = laPalabra + palabraNueva;

        return laPalabra;
    }

    static void main(String[] args) {
        String[] pruebas = {
                "aaabbcccc",
                "xxyyzz",
                "wwwww",
                "abc",
                "abracadabra"
        };

        for (int i = 0; i < pruebas.length; i++) {
            String original = pruebas[i];
            String comprimido = comprimirTexto(original);

            double muestra = (double) comprimido.length() / original.length() * 100;

            System.out.printf("Original: '%s' -> Comprimido: '%s' | %2.01f\n", original, comprimido, muestra);
        }
    }
}