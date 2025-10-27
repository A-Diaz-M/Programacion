void main() {
    IO.println("PONER EL NUMERO Y SUMAR SUS DIGITOS ENTRE SI");
    IO.println("Introduzca un numero y se sumaran los digitos entre si.\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num;

    do{
        num = Integer.parseInt(IO.readln(nombre+", que numero quieres que sume sus cifras?\n"));
    } while(num <= 0);

    int suma = 0;
    int numeroInicial = num;
    int digitos = 0;

    while (num > 0) {
        int resto = num % 10;
        suma+=resto;
        num = num / 10;
        digitos++;
    }
    String resultado = String.format("%s, la suma total del numero %d es: %d, y tiene: %d digitos.\n", nombre, numeroInicial, suma, digitos);
    IO.println(resultado);
}