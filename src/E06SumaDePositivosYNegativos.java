void main() {
    IO.println("SUMA DE POSITIVOS Y NEGATIVOS");
    IO.println("Introduzca valores\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", introduzca un numero:\n"));

    int sumaNega = 0;
    int sumaPosi = 0;
    int totalNums = 0;

    while (num != 0) {
        if (num < 0) {
            sumaNega += num;
        } else {
            sumaPosi += num;
        }
        totalNums++;
        num = Integer.parseInt(IO.readln(nombre + ", introduzca otro numero:\n"));
    }
    System.out.format("%s, la suma de positivos: %d, suma negativos: %d, total nums: %d\n", nombre, sumaPosi, sumaNega, totalNums);
}