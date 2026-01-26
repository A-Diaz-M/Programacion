package b800varios;

public class E822SumaTotalRecursivo {

    public static int sumaTotal(int num) {
        int a = Math.abs(num);

        if (a == 0 || a == 1) {
            return 1;
        }

        int suma = a + sumaTotal(a - 1);

        if (num < 0) {
            suma = -suma;
        }
        return suma;
    }

    static void main(String[] args) {
        System.out.println(sumaTotal(10));
    }
}