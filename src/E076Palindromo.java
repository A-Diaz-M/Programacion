StringBuilder alReves (String texto) {
    StringBuilder reves = new StringBuilder();

    for (int i = texto.length() - 1; i >= 0 ; i--) {
        char letra = texto.charAt(i);
        reves.append(letra);
    }
    return reves;
}

boolean esPalindromo(String texto, String reves) {
    return texto.equals(reves);
}

void main() {
    IO.println("PALINDROMO");
    IO.println("Introduzca una frase y se devolvera invertida y se dira si es palindroma\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    String palabra = IO.readln(nombre + ", introduzca una frase:\n");

   if (esPalindromo(palabra, String.valueOf(alReves(palabra)))) {
       IO.println("Es palindroma");
   } else {
       IO.println("No es palindroma");
   }
    IO.println(String.format("%s, la frase '%s' al reves es '%s'", nombre, palabra, alReves(palabra)));
}


//void main() {
//    IO.println("FRASE INVERTIDA");
//    IO.println("Introduzca una frase y se devolvera invertida\n");
//    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();
//
//    String palabra = IO.readln(nombre + ", introduzca una frase:\n");
//    boolean esIgual = false;
//
//    for (int i = 0; i < palabra.length()/2; i++) {
//        char izq = palabra.charAt(i);
//        char der = palabra.charAt(palabra.length()-1-i);
//        if (izq == der) {
//            esIgual = true;
//        }
//
//    }
//    if (esIgual) IO.println("Es palindroma");
//}