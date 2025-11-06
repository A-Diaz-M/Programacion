double calcularPotencia(double base, int exponente) {

    double base2 = base;
    for (int i = 1; i < exponente; i++) {
        base *= base2;
    }
    return base;
}

void main() {
    IO.println("POTENCIA");
    IO.println("Introduzca una base y un exponente y se calculara.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    double base = Integer.parseInt(IO.readln(nombre + ", introduzca la base.\n"));
    int exponente = Integer.parseInt(IO.readln(nombre + ", introduzca el exponente.\n"));
    IO.println(String.format("%s, %.0f^%d = %.2f", nombre, base, exponente, calcularPotencia(base,exponente)));

}