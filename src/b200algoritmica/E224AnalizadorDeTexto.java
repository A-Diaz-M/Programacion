private static String frase = "TEXTO DE PRUEBAAAAAA HOLA";

private static int contarPalabras(String texto) {
    int palabras = 1;

    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) == ' ') {
            palabras++;
        }
    }
    return palabras;
}

private static int contarPalabrasLargas(String texto) {
    int contador = 0;
    int longitudActual = 0;

    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) != ' ') {
            longitudActual++;
        } else {
            if (longitudActual >= 5) {
                contador++;
            }
            longitudActual = 0;
        }
    }
    if (longitudActual >= 5) {
        contador++;
    }
    return contador;
}

private static String palabraMasLarga(String texto) {
    StringBuilder palabraActual = new StringBuilder();
    String palabraMasLarga = "";

    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) != ' ') {
            palabraActual.append(texto.charAt(i));
        } else {
            if (palabraActual.length() > palabraMasLarga.length()) {
                palabraMasLarga = palabraActual.toString();
            }
            palabraActual.setLength(0);
        }
    }
    if (palabraActual.length() > palabraMasLarga.length()) {
        palabraMasLarga = palabraActual.toString();
    }
    return palabraMasLarga;
}

void main() {
    int totalPalabras = contarPalabras(frase);
    int palabrasLargas = contarPalabrasLargas(frase);
    String palabraMasLarga = palabraMasLarga(frase);

    IO.println("El texto tiene " + totalPalabras + " palabras.");
    IO.println("De ellas, " + palabrasLargas + " son largas (5 caracteres o más).");
    IO.println("La palabra más larga es " + palabraMasLarga +" y tiene " + palabraMasLarga.length() + " caracteres.");
}



