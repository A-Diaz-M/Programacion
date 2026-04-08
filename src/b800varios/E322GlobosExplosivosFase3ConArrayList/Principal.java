package b800varios.E322GlobosExplosivosFase3ConArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Globo> globos = new ArrayList<>();

        globos.add(new Globo());
        globos.add(new Globo(10));
        globos.add(new Globo(10));

        for (int i = 0; i < 2; i++) {  //for para los primeros dos globos - 1 jugador
            Globo g = globos.get(i);

            while (!g.estaExplotado()) {
                System.out.println("Cuanto quieres inflar el globo " + (i + 1) + " ?");

                int aire = scanner.nextInt();
                g.inflar(aire);
                System.out.println(g);
            }
            System.out.println("El globo " + (i + 1) + " ha explotado");
        }

        Globo g3 = globos.get(2); // 2 jugadores

        int turno = 1;

        while (!g3.estaExplotado()) {
            System.out.println(String.format("Jugador %d, cuanto quieres inflar el globo 3?", turno));

            g3.inflar(scanner.nextInt());

            turno = 3 - turno;

            // Esto hace lo mismo:
            // if (turno == 1) turno = 2;
            // else turno = 1;
        }

        System.out.println("El globo 3 ha explotado");

        System.out.format("Enhorabuena jugador %d, has ganado!", turno);
    }
}