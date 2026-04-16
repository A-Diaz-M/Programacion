package b800varios.E801EscrituraLecturaFicheroTexto;

import java.io.*;
import java.util.Scanner;

public class E801EscrituraLecturaFicheroTexto {
    static void main(String[] args) {
        System.out.println("\nESCRITURA EN DATOS.TXT: ");
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter("src/b800varios/E801EscrituraLecturaFicheroTexto/datos.txt")));
            for (int i = 1; i <= 10; i++) {
                System.out.println("Escribiendo número: " + i);
                salida.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (salida != null) salida.close();
        }

        System.out.println("\nLECTURA DE DATOS.TXT: ");
        Scanner entrada = null;
        try {
            entrada = new Scanner(new BufferedReader(new FileReader("src/b800varios/E801EscrituraLecturaFicheroTexto/datos.txt")));
            while (entrada.hasNext()) {
                String cadena = entrada.next();
                System.out.println("Leído número: " + cadena);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) entrada.close();
        }
    }
}