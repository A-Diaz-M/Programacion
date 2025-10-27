void main() {
    IO.println("ADIVINAR EL NUMERO SECRETO");

    String jugador1 = IO.readln("Dime como te llamas jugador 1:\n").toUpperCase();
    IO.println(jugador1+", introduce un numero secreto entre el 0 y el 100 y el Jugador 2 tiene que adivinarlo en 5 intentos.\n");

    int numSecreto;
    do {
        numSecreto = Integer.parseInt(IO.readln(jugador1+", introduzca un numero secreto:\n"));
    } while (numSecreto <= 0 || numSecreto > 100);

    IO.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    int numAdivinar;
    int numIntentos = 5;
    int diferencia;
    String temperatura;
    String jugador2 = IO.readln("Dime como te llamas jugador 2:\n").toUpperCase();

    do {
        numAdivinar = Integer.parseInt(IO.readln(jugador2+", introduzca el numero a adivinar:\n"));

        diferencia = Math.abs (numAdivinar - numSecreto);

        if (diferencia < 5) temperatura = "Y TE QUEMAS!!";
        else if (diferencia < 10) temperatura = ", estas caliente";
        else if (diferencia < 15) temperatura = ", estas templado";
        else if (diferencia < 20) temperatura = ", estas frío";
        else if (diferencia < 30) temperatura = ", estas tieso";
        else temperatura = "y eres un cubito de hielo";

        if (numAdivinar > numSecreto) {
            IO.println(String.format("%s, el numero secreto es menor, le quedan %d intentos %s", jugador2, (numIntentos - 1), temperatura));
            IO.println("*".repeat(diferencia/10));
            numIntentos--;

        } else if (numAdivinar < numSecreto) {
            IO.println(String.format("%s, el numero secreto es mayor, le quedan %d intentos %s", jugador2, (numIntentos - 1), temperatura));
            IO.println("*".repeat(diferencia/10));
            numIntentos--;

        } else {
            IO.println(String.format("¡¡¡Enhorabuena %s, el numero secreto era %d!!!", jugador2, numSecreto));

        }

    } while ((numAdivinar != numSecreto) && (numIntentos > 0));

    if (numIntentos == 0){
        IO.println(String.format("%s, perdiste.", jugador2));

    }
}