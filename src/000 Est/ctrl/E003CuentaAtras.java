void main() {
    IO.println("CUENTA ATRAS");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();
    int num = Integer.parseInt(IO.readln(nombre + ", a partir de que numero quieres empezar la cuenta atras?\n"));

    for (int i = num; i >= 1; i--) {
        IO.println(i);
    }
    System.out.printf("¡Despegas, %s!\n", nombre);
}