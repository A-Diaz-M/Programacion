package b900programame;

import java.util.LinkedList;
import java.util.Scanner;

public class E935TecladoEstropeado144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();

            LinkedList<Character> izquierda = new LinkedList<>();
            LinkedList<Character> derecha   = new LinkedList<>();

            for (char c : linea.toCharArray()) {
                switch (c) {

                    case '-':
                        while (!izquierda.isEmpty())
                            derecha.addFirst(izquierda.removeLast());
                        break;

                    case '+':
                        while (!derecha.isEmpty())
                            izquierda.addLast(derecha.removeFirst());
                        break;

                    case '*':
                        if (!derecha.isEmpty())
                            izquierda.addLast(derecha.removeFirst());
                        break;

                    case '3':
                        if (!derecha.isEmpty())
                            derecha.removeFirst();
                        break;

                    default:
                        izquierda.addLast(c);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : izquierda) sb.append(ch);
            for (char ch : derecha)   sb.append(ch);
            System.out.println(sb);
        }
    }
}