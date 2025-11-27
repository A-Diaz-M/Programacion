void main() {
    IO.println("SUMAR TODOS LOS VALORES DE UN ARRAY ENTRE SI");
    IO.println("INTRODUCE UN NUMERO EL CUAL SERA PARA ASIGNAR CUANTAS POSICIONES TIENE EL ARRAY Y DESPUES INTRODUCIRAS UNO A UNO LOS VALORES Y DESPUES SE SUMARAN ENTRE SI.\n");

    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", cuantos numeros quieres?\n"));
    int[] numeros = new int[num];

    for (int i = 0; i < numeros.length; i++) {
        numeros[i] = Integer.parseInt(IO.readln(nombre + ", introduzca el " + (i + 1) + " numero.\n"));
    }

    int sumaTotal = 0;
    for (int valor : numeros) {
        sumaTotal += valor;
    }
    IO.println(String.format("%s, la suma total es de %d, gracias.", nombre, sumaTotal));
}