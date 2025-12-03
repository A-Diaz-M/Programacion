void main() {
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int cantLetras = Integer.parseInt(IO.readln(nombre + ", introduzca la cantidad de letras que tiene tu palabra:\n"));

    char[] array = new char[cantLetras];
    boolean[] aciertos = new boolean[cantLetras];

    for (int i = 0; i < array.length; i++) {
        array[i] = IO.readln(nombre + ", introduzca una letra:\n").charAt(0);
    }

    IO.println("\n--- JUGADOR 2 ---\n");

    String nombre2 = IO.readln("Dime como te llamas:\n").toUpperCase();
    int intentos = 5;
    boolean todasAcertadas;
    IO.println(String.format("Tienes %d intentos.", intentos));

    do {
        IO.print("Progreso: ");
        for (int i = 0; i < array.length; i++) {
            if (aciertos[i])
                IO.print(array[i] + " ");
            else
                IO.print("_ ");
        }

        IO.println("");
        char letraComprobada = IO.readln(nombre2 + ", introduce una letra:\n").charAt(0);

        boolean encontrada = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == letraComprobada) {
                aciertos[i] = true;
                encontrada = true;
            }
        }

        if (encontrada) {
            IO.println("LETRA ENCONTRADA.");
        } else {
            IO.println("Letra no encontrada.");
            intentos--;
            IO.println("Intentos: " + intentos);
        }

        todasAcertadas = true;
        for (boolean acierto : aciertos) {
            if (!acierto) {
                todasAcertadas = false;
                break;
            }
        }

    } while (intentos > 0 && !todasAcertadas);

    if (intentos == 0) {
        IO.println("GAME OVER");
    } else {
        IO.println("\n¡Muy bien! Has adivinado todas las letras:");
        for (char c : array) {
            IO.print(c + " ");
        }
    }
}