package b800varios;

public class E823FibonacciRecursivo {
    public static int fibonacci(int num) {
        if (num == 1) {
            return 0;

        } else if (num == 2) {
            return 1;

        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);

        }
    }

    static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}