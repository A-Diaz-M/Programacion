void main() {
    int[] fibonacci = new int[30];
    fibonacci[0] = 0;
    fibonacci[1] = 1;

    for (int i = 2; i < fibonacci.length; i++){
        fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
    }
    IO.println(Arrays.toString(fibonacci));
}