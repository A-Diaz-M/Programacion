void main() {
    int[] numeros = {17, 23, 5, 21};
    for (int numeroActual : numeros) {
        IO.println(numeroActual);
    }

    IO.println();

    double[] longitudes = {11.36, 0.0, 1.184, -3.98, 1495739.2};
    for (double numeroActualDouble : longitudes) {
        IO.println(numeroActualDouble);
    }

    IO.println();

    boolean[] indicadores = {false, false, true, false, true};
    for (boolean indicador : indicadores) {
        IO.println(indicador);
    }
}