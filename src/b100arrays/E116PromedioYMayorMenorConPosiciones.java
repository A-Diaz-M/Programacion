void main() {

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();
    int num;
    double sumaTotal = 0;
    int numMayor = Integer.MIN_VALUE;
    int posMayor = 0;
    int numMenor = Integer.MAX_VALUE;
    int posMenor = 0;

    do {
        num = Integer.parseInt(IO.readln(nombre + ", cuantos numeros quieres?\n"));
    } while (num < 2);


    int[] valores = new int[num];

    for (int i = 0; i < valores.length; i++) {
        valores[i] = Integer.parseInt(IO.readln(nombre + ", introduzca un valor.\n"));
    }

    for (int i = 0; i < valores.length; i++) {
        sumaTotal += valores[i];
        if (valores[i] > numMayor) {
            numMayor = valores[i];
            posMayor = i + 1;
        }
        if (valores[i] < numMenor) {
            numMenor = valores[i];
            posMenor = i + 1;
        }
    }


    IO.println(String.format("%s, el promedio es %.1f", nombre, sumaTotal / valores.length));
    IO.println(String.format("%s, el mayor %d (posición %d) y el menor era %d (posición %d).", nombre, numMayor, posMayor, numMenor, posMenor));
}