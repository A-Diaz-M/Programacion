package b900programame;

import java.util.Scanner;

public class E907Coetaneos751 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int T = teclado.nextInt();

        while (T-- > 0) {
            int n1 = teclado.nextInt();
            int m1 = teclado.nextInt();
            int n2 = teclado.nextInt();
            int m2 = teclado.nextInt();

            int inicio = Math.max(n1, n2);
            int fin = Math.min(m1, m2);

            if (inicio > fin)
                System.out.println(0);
            else
                System.out.println(fin - inicio + 1);
        }
    }
}