void main() {
    int[] todos = new int[20];
    int cantidadPares = 0;
    int cantidadImpares = 0;
    int posPares = 0;
    int posImpares = 0;
    Random numeroAleatorio = new Random();



    for (int i = 0; i < todos.length; i++) {
        todos[i] = numeroAleatorio.nextInt(100) +1;
        if (todos[i] % 2 == 0) {
            cantidadPares++;
        } else {
            cantidadImpares++;
        }
    }

    int[] pares = new int[cantidadPares];
    int[] impares = new int[cantidadImpares];

    for (int i = 0; i < todos.length; i++){
        if (todos[i] % 2 == 0) {
            pares[posPares] = todos[i];
            posPares++;
        } else {
            impares[posImpares] = todos[i];
            posImpares++;
        }
    }
    IO.println("ARRAY RANDOM ENTERO");
    IO.println(Arrays.toString(todos));
    IO.println("ARRAY PARES");
    IO.println(Arrays.toString(pares));
    IO.println("ARRAY IMPARES");
    IO.println(Arrays.toString(impares));
}