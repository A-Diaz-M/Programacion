void main() {
    IO.println("MULTIPLICACIÓN SIMPLE CON NEGATIVOS");
    String nombre = IO.readln("Dime como te llamas:\n");

    int a = Integer.parseInt(IO.readln("Introduzca un numero:\n"));
    int b = Integer.parseInt(IO.readln("Introduzca otro numero:\n"));

    int resultado = 0;

    for (int i = 0;i != b;i++) {
        resultado+=a;
    }
    System.out.format("%s, la multiplicacion de %d x %d = %d",nombre, a, b, resultado);
}