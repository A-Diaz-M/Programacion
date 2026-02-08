package b300oobasica.E321ArrayListBasico;

import java.util.ArrayList;

public class Main {
    public static class Principal {
        public static void main(String[] args) {
            ArrayList<Integer> lista1 = new ArrayList<>();
            ArrayList<Integer> lista2 = new ArrayList<>();

            lista1.add(50);
            lista1.add(100);
            lista1.add(60);

            lista1.add(1, 43);

            System.out.println(lista1);

            System.out.printf("Tamaño guardado en la lista1: %d%n", lista1.size());

            System.out.printf("Indice 1: %d%n", lista1.get(1));

            System.out.printf("La lista1 contiene el número 90?: %b%n", lista1.contains(90));

            System.out.printf("La lista1 contiene el número 50?: %b%n", lista1.contains(50));

            lista1.remove(new Integer(43));
            lista1.remove(Integer.valueOf(43)); // Hace lo mismo que el anterior.

            System.out.printf("La lista1 tiene el número 43?: %b%n", lista1.contains(43));

            lista2.add(100);
            lista2.add(200);

            lista1.addAll(lista2);

            System.out.printf("Tamaño después de addAll: %d%n", lista1.size());

            System.out.println("Contenido en la lista1: ");

            for (int i = 0; i < lista1.size(); i++) {
                System.out.printf("La posición %d -> %d%n", i, lista1.get(i));
            }

            for (int n : lista1) {
                System.out.printf("La posición ? -> %d%n", n);
            }

            lista2.clear();

            System.out.printf("lista2 está vacía?: %b%n", lista2.isEmpty());
        }
    }
}
