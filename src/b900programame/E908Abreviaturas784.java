package b900programame;

import java.util.Scanner;

public class E908Abreviaturas784 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            String linea = sc.nextLine().trim();
            String[] partes = linea.split(" ");

            StringBuilder res = new StringBuilder();

            for (int i = 0; i < partes.length; i++) {
                char letra = partes[i].charAt(0); // la letra
                res.append(letra).append(letra).append('.');

                if (i < partes.length - 1)
                    res.append(" ");
            }
            System.out.println(res);
        }
    }
}