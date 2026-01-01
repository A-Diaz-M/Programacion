void main(String[] args) {
    IO.println("Hola, esto es una calculadora que te permite sumar, restar, multiplicar y dividir.");

    int validacion;
    do {
        double num = Integer.parseInt(IO.readln("Introduzca un numero:\n"));
        int funcion = Integer.parseInt(IO.readln("Introduce \n '1' para sumar              '+'\n '2' para restar             '-'\n '3' para multiplicar        '*'\n '4' para dividir            '/'\n '5' para hacer potencia     '^'\n '6' para hacer Raíz n-ésima '√'\n"));
        double num2 = Integer.parseInt(IO.readln("Introduzca un numero:\n"));

        double resultado = 0;

        switch (funcion) {
            case 1 -> resultado = num + num2;
            case 2 -> resultado = num - num2;
            case 3 -> resultado = num * num2;
            case 4 -> resultado = num / num2;
            case 5 -> resultado = Math.pow(num, num2);
            case 6 -> resultado = Math.pow(num, 1.0/num2);
        }

        IO.println(String.format("El resultado es: %.2f", resultado));
        validacion = Integer.parseInt(IO.readln("Si no desea seguir usando la calculadora introduzca '0':\n"));

    } while (validacion != 0);
}