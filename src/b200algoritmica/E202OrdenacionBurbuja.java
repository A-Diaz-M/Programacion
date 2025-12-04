void main() {
    int[] lista = {5, 8, 15, 20, 3, 8, 10, 7};
    int numGuardado;

    for (int i = 0; i < lista.length - 1; i++) {
        for (int j = 0; j < lista.length - 1 - i; j++) {
            if (lista[j] > lista[j + 1]) {
                numGuardado = lista[j + 1];
                lista[j + 1] = lista[j];
                lista[j] = numGuardado;
            }
        }
    }
    IO.println(Arrays.toString(lista));
}