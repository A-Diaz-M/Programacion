void main() {
    IO.println("FACTORIAL RECURSIVO");
    String nombre = IO.readln("Dime como te llamas:\n");

    int num = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));
    int base = 1;

    int a = Math.abs(num);

    for (int i = 1; i <= a; i++){

        base = i * base;

    }

    if (num < 0 ) {
        base = -base;
    }
    System.out.format("El numero %d factorial iterativo es igual a: %d\n", num, base);
}