void dibujarOla (int num) {
    for (int j = 1; j <= num; j++) {
        IO.println("*".repeat(j));
    }

    for (int k = num - 1; k >= 1; k--) {
        IO.println("*".repeat(k));
    }
}

void dibujarOlas (int numOla, int numAmplitud) {
    for (int i = 0; i < numOla; i++) {
        dibujarOla(numAmplitud);
    }
}

void main() {
    IO.println("OLAS");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int numOlas;
    int amplitudMax;
    do {
        numOlas = Integer.parseInt(IO.readln(nombre + ", introduzca un numero de olas:\n"));
        amplitudMax = Integer.parseInt(IO.readln(nombre + ", introduzca un numero de altura de las olas:\n"));
        if (numOlas < 0) IO.println("No puedes poner cantidad de olas negativas") ;
        if (amplitudMax < 0) IO.println("No puedes poner amplitud maxima");
    } while (numOlas < 0 && amplitudMax < 0);

    dibujarOlas(numOlas, amplitudMax);
    IO.println(String.format("%s, te he hecho %d olas con %d de amplitud, DE NADA :D.\n", nombre, numOlas, amplitudMax));
}