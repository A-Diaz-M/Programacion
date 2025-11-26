void main() {
    IO.println("SUMA DE IMPARES Y PARES HASTA PARAR CON '0'");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int cantidad = Integer.parseInt(IO.readln(nombre + ", dime un numero y sumare entre si todos los pares e impares hasta el:\n"));
    int sumaImpar = 0;
    int sumaPar = 0;

    for (int i = 1; i <= cantidad; i++) {
        if (i % 2 == 1) {
            sumaImpar += i;
        } else {
            sumaPar += i;
        }
    }
    System.out.printf("%s, la suma de los pares es %d y los impares %d\n", nombre, sumaPar, sumaImpar);
}