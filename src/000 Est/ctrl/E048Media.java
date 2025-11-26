void main() {
    IO.println("MEDIA ARITMETICA");
    IO.println("Introduzca los valores que quiera y se calculara la media aritmetica si introduce '0'.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num;
    int cantidadNumeros = 0;
    double media = 0;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", introduce un numero o pulse '0' para parar.\n"));
        if (num > 0) {
            media += num;
            cantidadNumeros++;
        }
    } while (num != 0);

    IO.println(String.format("%s, la media aritmetica es %.2f", nombre, media / cantidadNumeros));
}