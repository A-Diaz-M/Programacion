void main() {
    int[] arrayA = {52, 5, 9, 6, 7};
    int[] arrayB = {17, 25, 9};

    int max = Math.max(arrayA.length, arrayB.length);

    for (int i = 0; i < max; i++) {
        if (i >= arrayA.length) {
            IO.println(String.format("En la posición %d el array A no tiene valor, el valor del B es '%d'", (i + 1), arrayB[i]));
        } else if (i >= arrayB.length) {
            IO.println(String.format("En la posición %d el array B no tiene valor, el valor del A es '%d'", (i + 1), arrayA[i]));
        } else if (arrayA[i] > arrayB[i]) {
            IO.println(String.format("El valor %d del array A es mayor que el B", i + 1));
        } else if (arrayA[i] < arrayB[i]) {
            IO.println(String.format("El valor %d del array B es mayor que el A", i + 1));
        } else if (arrayA[i] == arrayB[i]) {
            IO.println(String.format("El valor %d del array A es igual que el B", i + 1));
        }
    }

    IO.println();

    double[] arrayA2 = {6.14, 20.32, 3.1415926535897932384626433, 5.65};
    double[] arrayB2 = {15.33, 1.01, 3.1415926535897932384626433};

    int max2 = Math.max(arrayA2.length, arrayB2.length);

    for (int i = 0; i < max2; i++) {
        if (i >= arrayA2.length) {
            IO.println(String.format("En la posición %d el array A no tiene valor, el valor del B es '%.2f'", (i + 1), arrayB2[i]));
        } else if (i >= arrayB2.length) {
            IO.println(String.format("En la posición %d el array B no tiene valor, el valor del A es '%.2f'", (i + 1), arrayA2[i]));
        } else if (arrayA2[i] > arrayB2[i]) {
            IO.println(String.format("El valor %d del array A2 es mayor que el B2", i + 1));
        } else if (arrayA2[i] < arrayB2[i]) {
            IO.println(String.format("El valor %d del array B2 es mayor que el A2", i + 1));
        } else if (arrayA2[i] == arrayB2[i]) {
            IO.println(String.format("El valor %d del array A2 es igual que el B2", i + 1));
        }
    }

    IO.println();

    boolean[] arrayA3 = {false, true, true, true};
    boolean[] arrayB3 = {false, true, false};

    int max3 = Math.max(arrayA3.length, arrayB3.length);

    for (int i = 0; i < max3; i++) {
        if (i >= arrayA3.length) {
            IO.println(String.format("En la posición %d el array A no tiene valor, el valor del B es '%s'", (i + 1), arrayB3[i]));
        } else if (i >= arrayB3.length) {
            IO.println(String.format("En la posición %d el array B no tiene valor, el valor del A es '%s'", (i + 1), arrayA3[i]));
        } else if (arrayA3[i] != arrayB3[i]) {
            IO.println(String.format("El valor %d del array A3 es distinto B3", i + 1));
        } else if (arrayA3[i] == arrayB3[i]) {
            IO.println(String.format("El valor %d del array A3 es igual que el B3", i + 1));
        }
    }
}