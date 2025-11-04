void main() {
    IO.println("NUMEROS EN RANGO");
    IO.println("Introduzca 2 numeros y se mostraran los multiplos de 3 entre los mismos.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num1 = Integer.parseInt(IO.readln(nombre + ", desde que numero quieres ver los multiplos de 3?\n"));
    int num2 = Integer.parseInt(IO.readln(nombre + ", hasta que numero quieres ver los multiplos de 3?\n"));

    for (int i = num1; i <= num2; i++) {
        if (i % 3 == 0) {
            IO.println(i);
        }
    }
}