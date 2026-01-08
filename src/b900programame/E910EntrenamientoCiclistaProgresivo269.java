package b900programame;

import java.util.Scanner;

public class E910EntrenamientoCiclistaProgresivo269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int acumulado = 0;
            int total = 0;

            while (true) {
                int x = sc.nextInt();
                if (x == 0) break;

                acumulado += x;
                total += acumulado * 2;
            }
            System.out.println(total);
        }
    }
}