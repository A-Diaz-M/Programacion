void main() {
    IO.println("1 al 10 con FOR");
    for (int i = 1; i <= 10; i++) {
        IO.print(i + " ");
    }

    IO.println();
    IO.println();

    IO.println("1 al 10 con WHILE");
    int b = 1;
    while (b <= 10) {
        IO.print(b + " ");
        b++;
    }

    IO.println();
    IO.println();

    IO.println("1 al 10 con DO WHILE");
    int c = 1;
    do {
        IO.print(c + " ");
        c++;
    } while (c <= 10);

    IO.println();
    IO.println();
    IO.println();
    IO.println();

    IO.println("2 al 20 con FOR de 2 en 2");
    for (int i = 2; i <= 20; i = i + 2) {
        IO.print(i + " ");
    }

    IO.println();
    IO.println();

    IO.println("2 al 20 con WHILE de 2 en 2");
    int d = 2;
    while (d <= 20) {
        IO.print(d + " ");
        d = d + 2;
    }

    IO.println();
    IO.println();

    IO.println("2 al 20 con DO WHILE de 2 en 2");
    int e = 2;
    do {
        IO.print(e + " ");
        e = e + 2;
    } while (e <= 20);
}