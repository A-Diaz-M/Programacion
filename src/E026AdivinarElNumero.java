void main() {
    IO.println("ADIVINAR EL NUMERO SECRETO");

    String nombre = IO.readln("Dime como te llamas jugador 1:\n").toUpperCase();
    IO.println(nombre+", introduce un numero secreto entre el 0 y el 30 y el Jugador 2 tiene que adivinarlo en 5 intentos.\n");

    int numSecreto;

    do {
        numSecreto = Integer.parseInt(IO.readln(nombre+", introduzca un numero secreto:\n"));
    } while (numSecreto <= 0 || numSecreto > 50);

    int numAdivinar;
    int numIntentos = 5;
    int diferencia;
    String temperatura = "";
    String nombre2 = IO.readln("Dime como te llamas jugador 2:\n").toUpperCase();

    do {
        numAdivinar = Integer.parseInt(IO.readln(nombre2+", introduzca el numero a adivinar:\n"));

        diferencia = numAdivinar - numSecreto;
        Math.abs(diferencia);


        if (numAdivinar > numSecreto) {
            //diferencia = numAdivinar - numSecreto;


            if (diferencia < 5) temperatura = "TE QUEMAS!!";
            if (diferencia < 10) temperatura = "caliente";
            if (diferencia < 15) temperatura = " templado";
            if (diferencia < 20) temperatura = "frío";
            if (diferencia < 30) temperatura = "helado";




            IO.println("El numero secreto es menor, le quedan "+(numIntentos - 1)+" intentos.");
            numIntentos--;
            IO.println("*".repeat(diferencia/10));
        } else if (numAdivinar < numSecreto) {
            //diferencia = numSecreto - numAdivinar;


            if (diferencia < 5) temperatura = "TE QUEMAS!!";
            if (diferencia < 10) temperatura = "caliente";
            if (diferencia < 15) temperatura = " templado";
            if (diferencia < 20) temperatura = "frío";
            if (diferencia < 30) temperatura = "helado";



            IO.println(String.format("%s, el numero secreto es menor, le quedan %d intentos y estas %s", nombre2, (numIntentos - 1), temperatura));
            numIntentos--;
            IO.println("*".repeat(diferencia/10));
        } else {
            IO.println("Enhorabuena Jugador 2, el numero secreto era " + numSecreto);
        }
    } while ((numAdivinar != numSecreto) && (numIntentos > 0));
    if (numIntentos == 0){
        IO.println("Jugador 2, perdiste.");
    }
}