void main() {
    IO.println("PONER EL NUMERO AL REVES Y SUMAR SUS DIGITOS ENTRE SI");
    IO.println("Introduzca un numero y se devolvera al reves empezando por el ultimo. (AÑADIDO: se suman los digitos entre si.)\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", que numero quieres al revesy sumar sus digitos?\n"));
    } while (num <= 0);

    int numInicial = num;
    int resultado = 0;
    int resto;
    int suma = 0;
    int digitos = 0;

    while (num > 0) {
        resto = num % 10;
        suma += resto;
        resultado += resto;
        if (num >= 10) {
            resultado = resultado * 10;
        }
        num = num / 10;
        digitos++;
    }
    System.out.format("%s, el numero %d al reves es %d y sumando sus dijitos entre si es: %d con %d digitos en total.\n", nombre, numInicial, resultado, suma, digitos);
}