void main() {
    IO.println("FRASE INVERTIDA");
    IO.println("Introduzca una frase y se devolvera invertida\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    String palabra = IO.readln(nombre + ", introduzca una frase:\n");
    StringBuilder reves = new StringBuilder();

    for (int i = palabra.length() - 1; i >= 0; i--) {
        char letra = palabra.charAt(i);
        reves.append(letra);
    }
    IO.println(String.format("%s, la frase '%s' al reves es '%s'", nombre, palabra, reves.toString()));
}