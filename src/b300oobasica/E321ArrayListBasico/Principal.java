package b300oobasica.E321ArrayListBasico;

import java.util.ArrayList;

public class Principal {
    public static class Principal2 {
        public static void main(String[] args) {
            ArrayList<Integer> lista = new ArrayList<Integer>();
            ArrayList<Integer> lista2 = new ArrayList<Integer>();
            ArrayList<Integer> lista3 = new ArrayList<Integer>();

            System.out.println("Lista sin nada: " + lista);

            lista.add(10);
            lista.add(20);
            lista.add(30);
            lista.add(40);

            System.out.println("Despues añadimos: " + lista);

            lista.add(1, 15);
            System.out.println("Despues del cambio añadido: " + lista);
            System.out.println("Tamaño de lista: " + lista.size());

            int posición = lista.get(2);
            System.out.println("Señala el objeto del posición 2: " + posición);

            System.out.println("Uso de get en for:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Posición " + i + "--> " + lista.get(i));
            }

            System.out.println("Si tiene 20 " + lista.contains(20));
            System.out.println("No tiene 100 " + lista.contains(100));

            lista.remove(new Integer(15));
            System.out.println("Despues de eliminar: " + lista);

            lista2.add(100);
            lista2.add(200);
            lista2.add(300);

            lista3.addAll(lista);
            lista3.addAll(lista2);

            System.out.println("lista y lista2 junto: " + lista3);

            lista2.clear();
            System.out.println("lista2 clear " + lista2);

            System.out.println("Ver si esta vacio " + lista2.isEmpty());

            lista.addFirst(5);
            lista.addLast(50);
            System.out.println("Añadir al primero y al ultimo " + lista);

            lista.removeFirst();
            lista.removeLast();
            System.out.println("Quitar al primero y al ultimo" + lista);
        }
    }
}
