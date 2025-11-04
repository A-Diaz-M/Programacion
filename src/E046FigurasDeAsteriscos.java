void main() {
    IO.println("FIGURAS EN ASTERISCOS");
    IO.println("Introduzca 2 numeros y realizara un rectangulo vacio de asteriscos.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();


    int num = Integer.parseInt(IO.readln(nombre + ", de que altura quieres el rectangulo?\n"));
    int num2 = Integer.parseInt(IO.readln(nombre + ", de que anchura quieres el rectangulo?\n"));

    for (int i = 1; i <= num; i++){
        for (int j = 1; j < num2; j++){
            if (i == 1 || i == num || j == 1 ){
                IO.print(("* "));

            } else {
                IO.print(("  "));
            }
        }
        IO.println(("* "));
    }
}