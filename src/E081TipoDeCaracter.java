String caracter (char caracter) {

    return switch (caracter) {
        case 'a', 'b', 'c', 'd', 'e', 'f',
             'g', 'h', 'i', 'j', 'k', 'l',
             'm', 'n', 'ñ', 'o', 'p', 'q',
             'r', 's', 't', 'u', 'v', 'w',
             'x', 'y', 'z'                 -> "letra minuscula";
        case 'A', 'B', 'C', 'D', 'E', 'F',
             'G', 'H', 'I', 'J', 'K', 'L',
             'M', 'N', 'Ñ', 'O', 'P', 'Q',
             'R', 'S', 'T', 'U', 'V', 'W',
             'X', 'Y', 'Z'                 -> "letra mayuscula";
        case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0  -> "numero";
        case ',', '.', '-', '(', ')', '¡',
             '!', '¿', '?', ' '                 -> "símbolo";
        default -> throw new IllegalStateException("Unexpected value: " + caracter);
    };

}



void main() {
    IO.println("DÍAS DE UN MES");
    IO.println("Introduzca un numero y se dira cuantos dias tiene el mes.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    String frase = IO.readln(nombre + ", introduzca una frase:\n");
    for (int i = 0; i < frase.length() ; i++) {
        char letra = frase.charAt(i);
        IO.println(caracter(letra));
    }
}