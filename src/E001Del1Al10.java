void main() {
    int b = 1;
    int c = 1;

    IO.println("1 al 10 con FOR");
    for (int i = 1; i <= 10; i++) {
        IO.print(i+" ");
    }
    IO.println("\n\n");

    IO.println("1 al 10 con WHILE");
    while (b <=10){
        IO.print(b+" ");
        b++;
    }
    IO.println("\n\n");

    IO.println("1 al 10 con DO WHILE");
    do {
        IO.print(c+" ");
        c++;
    } while (c <= 10);
}