void main() {
    IO.println("MULTIPLICACIÓN SIMPLE CON NEGATIVOS");
    String nombre = IO.readln("Dime como te llamas:\n");

    int a = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));
    int b = Integer.parseInt(IO.readln(nombre+", introduzca otro numero:\n"));

    int num = Math.abs(a);
    int num2 = Math.abs(b);
    int resultado = 0;

    for (int i = 1;i <= num2;i++){
        resultado += num;
    }

    if ((a < 0 && b > 0) || (a > 0 && b < 0)){
        resultado = -resultado;
    }
    System.out.format("%s, la multiplicacion de %d x %d = %d",nombre, a, b, resultado);
}