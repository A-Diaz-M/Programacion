int encuentraPosicionEnElTexto(String textoBuscado, String textoPrincipal) {
    for (int i = 0; i <= textoPrincipal.length() - textoBuscado.length(); i++) {
        boolean coincide = true;

        for (int j = 0; j < textoBuscado.length(); j++) {
            if (textoBuscado.charAt(j) != textoPrincipal.charAt(i + j)) {
                coincide = false; break;
            }
        }
        if (coincide) return i;
    }
    return -1;
}

void main() {
    IO.println("POSICIÓN TEXTO");
    IO.println("Introduzca 2 textos, el primero el principal y el segundo se buscara en que posicion esta en el principal, en caso de no estar se devolvera '-1'\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    String principal = IO.readln(nombre + ", introduzca la frase principal:\n");
    String buscador = IO.readln(nombre + ", introduzca la frase que sera buscada:\n");

    if (encuentraPosicionEnElTexto(buscador,principal) > -1) {
        IO.println(String.format("%s, la frase buscada esta en la posicion %d", nombre, encuentraPosicionEnElTexto(buscador, principal)));
    } else  {
        IO.println(String.format("%s, la frase buscada no esta en la principal", nombre));
    }
}
