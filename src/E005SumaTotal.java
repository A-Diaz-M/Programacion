void main() {

    String nombre = IO.readln("Dime como te llamas:\n");

    int cantidad = Integer.parseInt(IO.readln("¿Cuántos números desea sumar?\n"));

    int suma = 0;

    IO.println("Introduzca de uno a uno los "+cantidad+" números a continuación:");
    for (int i = 1;i <= cantidad;i++){
        int num = Integer.parseInt(IO.readln("Numero "+i+":\n"));

        suma+=num;
        if (i == cantidad) {
            IO.println(nombre+", la suma total es: "+suma+".");
        } else {
            IO.println("La suma actual da: " + suma+".");

        }
    }
}