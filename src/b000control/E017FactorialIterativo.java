void main() {
    IO.println("FACTORIAL RECURSIVO");
    String nombre = IO.readln("Dime como te llamas:\n");

    int num = Integer.parseInt(IO.readln(nombre + ", introduzca un numero:\n"));
    int resultado = 1;

    int a = Math.abs(num);

    for (int i = 1; i <= a; i++) {
        resultado = i * resultado;
    }

    if (num < 0) {
        resultado = -resultado;
    }
    System.out.format("El numero %d factorial iterativo es igual a: %d\n", num, resultado);
}