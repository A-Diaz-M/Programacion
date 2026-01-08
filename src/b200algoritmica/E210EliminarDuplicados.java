void main() {
    int[] numeros = {8, 10, 4, 10, 8, 5, 5, 10, 17, 2};
    int contador = 0;

    IO.println(Arrays.toString(numeros));

    for (int i = 0; i < numeros.length; i++) {
        for (int j = i + 1; j < numeros.length; j++) {
            if (numeros[i] == numeros[j]) {
                numeros[j] = 0;
            }
        }
        if (numeros[i] != 0) {
            contador++;
        }
    }

    int[] sinDuplicado = new int[contador];
    int posicion = 0;

    for (int numero : numeros) {
        if (numero != 0) {
            sinDuplicado[posicion] = numero;
            posicion++;
        }
    }
    IO.println(Arrays.toString(sinDuplicado));
}