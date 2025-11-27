void main() {
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    int num = Integer.parseInt(IO.readln(nombre + ", cuantos numeros quieres?\n"));
    int[] nums = new int[num];

    int numero = 0;

    for (int i = 0; i < nums.length; i++) {
        nums[i] = Integer.parseInt(IO.readln(nombre + ", introduzca el " + (i + 1) + " numero.\n"));
        if (nums[i] > numero) {
            numero = nums[i];
        }
    }

    IO.println(String.format("%s, el numero mayor es %d", nombre, numero));
}