package b900programame;

import java.util.Scanner;

public class E912EscudosRomanos119 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            long num = teclado.nextLong();
            if (num == 0) break;

            long total = 0;

            while (num > 0) {
                long k = (long) Math.sqrt(num);
                num -= k * k;
                total += k * k + 4 * k;
            }
            System.out.println(total);
        }
    }
}