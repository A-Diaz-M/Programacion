package b800varios;

public class E821FactorialRecursivo {

    public static int factorial(int num) {

        int a = Math.abs(num);

        if (a == 0 || a == 1) {
            return 1;
        }

        int resultado = a * factorial(a - 1);

        if (num < 0) {
            resultado = -resultado;
        }
        return resultado;
    }

    static void main(String[] args) {
        System.out.println(factorial(10));
    }
}