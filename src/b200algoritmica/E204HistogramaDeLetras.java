void main() {
    String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme...".toLowerCase();

    int[] caracteres = new int[26];

    for (int i = 0; i < frase.length(); i++) {
        for (int j = 0; j < 26; j++) {
            char caracterActual = frase.charAt(i);
            char caracter = (char) (97 + j);
            if (caracterActual == caracter) {
                caracteres[j]++;
            }
        }
    }

    for (int i = 0; i < caracteres.length; i++){
        char caracter = (char) (97 + i);

        IO.println(String.format("La letra '%s' esta un total: %d", (caracter), caracteres[i]));
    }
}