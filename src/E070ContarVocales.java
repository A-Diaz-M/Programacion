int contarVocales(String texto) {
    texto = Normalizer.normalize(texto.toLowerCase(), Normalizer.Form.NFD);
    texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    int cont = 0;

    for (int i = 0; i < texto.length(); i++) {
        char c = texto.charAt(i);
        IO.print(c+" ");
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            cont++;
        }
    }
    return cont;
}




void main() {
    IO.println("CONTAR VOCALES");
    IO.println("Introduzca una frase y se dira cuantas vocales y consonantes tiene.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toLowerCase();

    String s = String.format(IO.readln(nombre + ", introduzca una frase:\n"));

    IO.print(String.format("El string tiene %d caracteres y hay una letra %s en su posición 4.\n", s.length(), s.charAt(4)));

    IO.println();
    IO.println(String.format("La cantidad total de vocales es de %d", contarVocales(s)));
}