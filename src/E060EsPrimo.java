void esPrimo(int vueltas) {
    for (int i = 1; i <= vueltas; i++) {

        if (i == 1) {
            IO.println(i+", no es primo");
        } else if (i == 2 || i == 3 || i == 5 || i == 7) {
            IO.println(i+", es primo");
        } else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0){
            IO.println(i+", es primo");
        } else {
            IO.println(i+", no es primo");
        }
    }
}





void main() {
    IO.println("ES PRIMO");
    IO.println("Introduzca dividendo y un divisor y se dira si es divisible.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int vueltas = Integer.parseInt(IO.readln(nombre + ", hasta que numeros quieres saber si son primos o no?\n"));

   esPrimo(vueltas);
}