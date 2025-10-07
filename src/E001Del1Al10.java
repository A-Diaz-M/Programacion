void main() {

    IO.println("1 al 10 con FOR");
    for (int i = 1; i <= 10; i++) {
        IO.print(i+" ");
    }

    IO.println();
    IO.println();

    IO.println("1 al 10 con WHILE");
    int b = 1;
    while (b <=10){
        IO.print(b+" ");
        b++;
    }

    IO.println();
    IO.println();

    IO.println("1 al 10 con DO WHILE");
    int c = 1;
    do {
        IO.print(c+" ");
        c++;
    } while (c <= 10);
}