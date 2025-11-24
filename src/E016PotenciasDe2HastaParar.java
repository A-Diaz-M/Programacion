void main() {
    char letra = Character.toLowerCase(IO.readln("--Hola, introduzca 's' para iniciar el programa o 'n' para cancelar.--\n").charAt(0));

    while (letra != 'n' && letra != 's') {
        letra = Character.toLowerCase(IO.readln("--Porfavor, introduzca 's' para iniciar el programa o 'n' para cancelar.--\n").charAt(0));
    }

    if (letra == 's') {
        IO.println("------POTENCIAS------\n");

        String nombre = IO.readln("-Dime como te llamas:\n").toUpperCase();

        double base = Integer.parseInt(IO.readln(nombre + ", introduzca el numero base:\n"));
        double resultado = 1;
        int exponente = 0;

        double a = Math.abs(base);

        if ((base < 0)) resultado = -resultado;

        while (letra == 's') {

            System.out.format("-%s, su potencia %.0f^%d es %.0f\n\n", nombre, base, exponente, resultado);

            resultado = resultado * a;
            exponente++;

            letra = IO.readln(nombre + ", introduzca 's' para continuar o 'n' para parar:\n").charAt(0);

            if (letra == 'n') {
                System.out.format("-%s, hasta aqui la potencia, gracias.\n", nombre);
            }
        }
    } else {
        System.out.format("Adios.\n");
    }
}