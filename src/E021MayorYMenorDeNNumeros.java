void main() {
    IO.println("COMPARACION MAYOR O MENOR");
    IO.println("Introduzca cuantos valores quiere comparar y le dire cual es el mayor de todos y el menor.\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();
    int vueltas = Integer.parseInt(IO.readln(nombre+", cuantos numeros quieres comparar?\n"));
    int mayor = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;
    int num;

    System.out.printf("%s, introduzca todos los numeros a continuacion de uno en uno:\n", nombre);
    for (int i = 1; i <= vueltas; i++){
        num = Integer.parseInt(IO.readln());
        if (num < menor){
            menor = num;
        } else if (num > mayor) {
            mayor = num;
        }
    }
    System.out.printf("%s, el numero mayor es %d y el menor %d\n", nombre, mayor, menor);
}