int contarVocales(String texto) {
    texto = Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD);
    texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    int cont = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> cont++;
        }
    }
    return cont;
}

void main() {
    IO.println("CONTAR VOCALES");
    IO.println("Introduzca una frase y se dira cuantas vocales y consonantes tiene.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toLowerCase();

    String s = String.format(IO.readln(nombre + ", introduzca una frase:\n"));

    IO.println();
    IO.println(String.format("La cantidad total de vocales es de %d", contarVocales(s)));
}