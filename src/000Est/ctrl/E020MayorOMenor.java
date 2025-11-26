void main() {
    IO.println("MAYOR O MENOR");
    IO.println("Introduzca valores positivos y le diré si son menores o mayores, o iguales, que el anterior, o introduzca 0 para terminar:\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int numAnt = 1;

    System.out.format("%s, el primer valor es 1", nombre);
    int numActual = Integer.parseInt(IO.readln(", introduzca un numero:\n"));

    while (numActual != 0) {
        if (numActual < numAnt) {
            IO.println("Es menor que el anterior.\n");
        } else if (numActual > numAnt) {
            IO.println("Es mayor que el anterior.\n");
        } else {
            IO.println("Es igual que el anterior.\n");
        }
        numAnt = numActual;
        numActual = Integer.parseInt(IO.readln(nombre + ", introduzca otro numero:\n"));
    }
    System.out.format("Gracias por usar mi programa %s.\n", nombre);
}