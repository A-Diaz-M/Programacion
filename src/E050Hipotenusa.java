double calcularHipotenusa(double cateto1, double cateto2) {

    return Math.sqrt(Math.pow(cateto1, 2)+Math.pow(cateto2,2));
}



void main() {
    IO.println("HIPOTENUSA");
    IO.println("Introduzca los valores del cateto A y el cateto B y se dara la hipotenusa.\n");
    String nombre = IO.readln("Dime como te llamas:\n").toUpperCase();

    double catetoA = Integer.parseInt(IO.readln(nombre + ", introduzca el cateto A.\n"));
    double catetoB = Integer.parseInt(IO.readln(nombre + ", introduce el cateto B.\n"));

    IO.println(String.format("%s, el cateto A de %.2f con el cateto B de %.2f su hipotenusa da %.2f", nombre, catetoA, catetoB, calcularHipotenusa(catetoA, catetoB)));
}