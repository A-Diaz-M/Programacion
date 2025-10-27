void main() {
    IO.println("ADIVINAR EL NUMERO SECRETO");
    IO.println("El jugador 1 introduce un numero secreto entre el 0 y el 30 y el Jugador 2 tiene que adivinarlo en 5 intentos.\n");

    int numSecreto;

    do {
        numSecreto = Integer.parseInt(IO.readln("Jugador 1, introduzca un numero secreto:\n"));
    } while (numSecreto <= 0 || numSecreto > 30);

    int numAdivinar;
    int numIntentos = 5;

    IO.println("\n\n\n\n\n\n\n\n\n");

    do {
        numAdivinar = Integer.parseInt(IO.readln("Jugador 2, introduzca el numero a adivinar:\n"));
        if (numAdivinar > numSecreto) {
            IO.println("El numero secreto es menor, le quedan "+(numIntentos - 1)+" intentos.");
            numIntentos--;
        } else if (numAdivinar < numSecreto) {
            IO.println("El numero secreto es mayor, le quedan "+(numIntentos - 1)+" intentos.");
            numIntentos--;
        } else {
            IO.println("Enhorabuena Jugador 2, el numero secreto era " + numSecreto);
        }
    } while ((numAdivinar != numSecreto) && (numIntentos > 0));
    if (numIntentos == 0){
        IO.println("Jugador 2, perdiste.");
    }
}