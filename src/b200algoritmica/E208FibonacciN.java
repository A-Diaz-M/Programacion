public static final int N = 4;
public static final int HASTA = 30;

void main() {
    int[] fibonacci = new int[HASTA];
    fibonacci[0] = 0;
    fibonacci[1] = 1;
    fibonacci[2] = 1;
    fibonacci[3] = 2;

    for (int i = N; i < fibonacci.length; i++){
        if        (N == 4) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3] + fibonacci[i - 4];
        } else if (N == 3) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3];
        } else if (N == 2) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
    }
    IO.println(Arrays.toString(fibonacci));
}