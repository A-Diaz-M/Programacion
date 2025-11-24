void main() {
    IO.println("SUMA DE NUMEROS");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", hasta que sumero quieres sumar sus anteriores?\n"));
    int suma = 0;

    for (int i = 1; i <= num; i++) {
        suma += i;
    }
    IO.println(String.format("%s, la suma de 1 hasta %d es %d", nombre, num, suma));
}