private static int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};

void main() {
    char opcion;

    IO.println(Arrays.toString(numeros));

    do {
        IO.print("Introduce i para izquierda o d para derecha, o x para salir: ");
        opcion = IO.readln().toLowerCase().charAt(0);

        if (opcion == 'i' || opcion == 'd') {
            int saltos;

            do {
                IO.print("Dime cuántos saltos quieres hacer en esa dirección (mínimo 1): ");
                saltos = Integer.parseInt(IO.readln());
            } while (saltos < 1);

            saltos = saltos % numeros.length;

            if (opcion == 'i') {
                desplazarIzquierda(saltos);
            } else {
                desplazarDerecha(saltos);
            }
            IO.println(Arrays.toString(numeros));
        }

    } while (opcion != 'x');
    IO.println("Terminamos con los desplazamientos.");
}

private static void desplazarIzquierda(int saltos) {
    for (int i = 0; i < saltos; i++) {
        int primero = numeros[0];
        for (int j = 0; j < numeros.length - 1; j++) {
            numeros[j] = numeros[j + 1];
        }
        numeros[numeros.length - 1] = primero;
    }
}

private static void desplazarDerecha(int saltos) {
    for (int i = 0; i < saltos; i++) {
        int ultimo = numeros[numeros.length - 1];
        for (int j = numeros.length - 1; j > 0; j--) {
            numeros[j] = numeros[j - 1];
        }
        numeros[0] = ultimo;
    }
}