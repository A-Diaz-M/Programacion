boolean esDivisible (int dividendo, int divisor) {
    return dividendo % divisor == 0;
}

boolean esPrimo(int numero) {

    if (numero == 1) return false;
    for (int i = 2; i <= numero-1; i++) {
        if (esDivisible(numero,i)) return false;
    }
    return true;
}

void main() {
    IO.println("ES PRIMO");
    IO.println("Introduzca dividendo y un divisor y se dira si es divisible.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int vueltas = Integer.parseInt(IO.readln(nombre + ", hasta que numeros quieres saber si son primos o no?\n"));

    for (int i = 1; i <= vueltas; i++) {
        if (esPrimo(i)){
            IO.println(i+" es primo.");
        } else {
            IO.println(i+" no es primo.");
        }
    }
}