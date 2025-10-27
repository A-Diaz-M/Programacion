void multiplicacion (int num) {
    int mult;
    for(int i =  0; i <= 10; i++){
        mult = num * i;
        IO.println(String.format("%d * %d = %d", num, i, mult));
    }
}

void main() {
    IO.println("TABLA DE MULTIPLICAR");
    IO.println("Introduzca un numero y le dire su tabla de multiplicar del 0 al 10.\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));
    multiplicacion(num);

    IO.println(nombre+", gracias por usar mi programa.");
}