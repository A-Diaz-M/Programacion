void main() {
    IO.println("DETECTAR REPETICIONES");
    IO.println("Introduzca numeros y si pone el mismo numero que el anterior puesto el programa finalizara.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int numAnt = 1;
    int intentos = Integer.parseInt(IO.readln(nombre + ", con cuantos numeros consecuitivos quieres parar?\n"));
    int intentosIniciales = intentos;
    IO.println(String.format("%s, el primer valor es 1", nombre));
    int numActual;

    do {
        numActual = Integer.parseInt(IO.readln(nombre + ", introduzca otro numero:\n"));
        if (numAnt == numActual) {
            intentos--;
        } else {
            intentos = intentosIniciales;
        }
        numAnt = numActual;
    } while (intentos != 1);

    IO.println(String.format("Gracias por usar mi programa %s.\n", nombre));
}
