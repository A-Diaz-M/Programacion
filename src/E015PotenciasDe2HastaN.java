void main() {
    IO.println("POTENCIAS");
    String nombre = IO.readln("Dime como te llamas:\n");

    double base = Integer.parseInt(IO.readln(nombre+", introduzca un numero base:\n"));
    double exponente = Integer.parseInt(IO.readln(nombre+", introduzca un numero exponente:\n"));
    double resultado = 1;

    double a = Math.abs(base);
    double b = Math.abs(exponente);

    for (int i = 1; i <= b; i++){
        resultado = resultado * a;
    }

    if (exponente < 0) resultado = 1/resultado;
    System.out.format("%s, su potencia %.0f^%.0f es %.0f\n\n", nombre, base, exponente, resultado);
}