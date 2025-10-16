void main() {
    IO.println("DIVISIONES");
    String nombre = IO.readln("Dime como te llamas:\n");

    int num = Integer.parseInt(IO.readln(nombre+", introduzca un numero:\n"));
    int num2 = Integer.parseInt(IO.readln(nombre+", introduzca otro numero:\n"));

    while ((num == 0) || (num2 == 0)){
        System.out.format("%s, no puedes dividir %d entre %d\n", nombre, num, num2);
        if ((num == 0)) {
            num = Integer.parseInt(IO.readln(nombre + ", introduzca otro numero dividendo distinto de 0 porfavor:\n"));
        } else {
            num2 = Integer.parseInt(IO.readln(nombre+", introduzca otro numero divisor distinto de 0 porfavor:\n"));
        }
    }

    int a = Math.abs(num);
    int b = Math.abs(num2);

    int cociente = 0;

    while (a >= b) {
        a = a - b;
        cociente++;
    }

    if ((num < 0 && num2 > 0) || (num > 0 && num2 < 0)){
        cociente = -cociente;
    }
    System.out.format("%s, el cociente de %d/%d es %d con resto de %d", nombre, num, num2,cociente, a);
}