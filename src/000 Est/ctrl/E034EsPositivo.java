boolean esPositivo(int num) {
    return num >= 0;
}

void main() {
    int num = Integer.parseInt(IO.readln("Introduzca un numero:\n"));
    if (esPositivo(num)) {
        IO.println("es positivo");
    } else {
        IO.println("es negativo");
    }
}