String numero (int num) {
   return switch (num) {
        case 1,3,5,7,8,10,12 -> "tiene 31 días";
        case 4,6,9,11 -> "tiene 30 dias";
        case 2 -> "tiene 28 dias o 29 en año bisiesto";
        default -> throw new IllegalStateException("Unexpected value: " + num);
    };
}



void main() {
    IO.println("DÍAS DE UN MES");
    IO.println("Introduzca un numero y se dira cuantos dias tiene el mes.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre+", introduce un numero del 1 al 12\n"));

    IO.println(String.format("%s, el mes %d tiene %s.", nombre, num, numero(num)));
}