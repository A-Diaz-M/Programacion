void main() {
    int numero;
    int suma = 0;
    do{
        numero = Integer.parseInt(IO.readln("Introduzca un numero\n"));
        if(numero > 100){
            suma += numero;
        }
    } while (numero!=0);
    IO.println(String.format("La suma de los numeros mayores que 100 es: %d", suma));
}