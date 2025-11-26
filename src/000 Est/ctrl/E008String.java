void main() {
    IO.println("PONER EL NUMERO Y SUMAR SUS DIGITOS ENTRE SI");
    IO.println("Introduzca un numero y se sumaran los digitos entre si.\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    String numero = IO.readln(nombre + ", dime un numero:\n");
    int suma = 0;

    int digitos = 0;

    for (int i = 0; i < numero.length(); i++) {
        char num = numero.charAt(i);
        suma += Character.getNumericValue(num);
        digitos++;
    }
    System.out.format("%s, la suma de los dígitos del numero %s es: %d con %d digitos.\n", nombre, numero, suma, digitos);
}