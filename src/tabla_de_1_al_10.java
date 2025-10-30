void main() {
    int numero = 1;

    while (numero <= 10) {
        IO.println("tabla del "+numero);
        for(int i = 1; i <= 10; i++){
            IO.println(String.format("%d x %d = %d",numero, i,(numero*i)));
        }
        numero++;
        IO.print("\n");
    }
}