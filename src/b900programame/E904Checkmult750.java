package b900programame;

import java.util.Scanner;

public class E904Checkmult750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String n = sc.nextLine();
            if (n.equals("0")) break;

            int zeros = 0;

            while (n.length() > 1) {
                int prod = 1;
                for (int i = 0; i < n.length(); i++) {
                    char c = n.charAt(i);
                    if (c == '0') zeros++;
                    else prod *= (c - '0');
                }
                n = Integer.toString(prod);
            }
            System.out.println(n + zeros);
        }
    }
}