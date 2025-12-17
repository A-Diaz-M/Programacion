package b900programame;

import java.util.Scanner;

public class E918Checkmult750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String num = sc.nextLine();
            if (num.equals("0")) break;

            int zeros = 0;

            while (num.length() > 1) {
                int prod = 1;
                for (int i = 0; i < num.length(); i++) {
                    char caracter = num.charAt(i);
                    if (caracter == '0') {
                        zeros++;
                    } else {
                        prod *= (caracter - '0');
                    }
                }
                num = Integer.toString(prod);
            }
            System.out.println(num + zeros);
        }
    }
}