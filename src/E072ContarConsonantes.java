int contarConsonantes(String texto) {
    texto = Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD);
    texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    int cont = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (c >= 'b' && c <= 'z' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
            cont++;
        }
    }
    return cont;
}

int contarVocales(String texto) {
    texto = Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD);
    texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    int cont = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            cont++;
        }
    }
    return cont;
}

void main() {
    IO.println("CONTAR CONSONANTES Y VOCALES");
    IO.println("Introduzca una frase y se dira cuantas consonantes tiene y vocales.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toLowerCase();

    String s = String.format(IO.readln(nombre + ", introduzca una frase:\n"));

    IO.println();
    IO.println(String.format("La cantidad total de consonantes es de %d y de vocales de %d", contarConsonantes(s), contarVocales(s)));
}