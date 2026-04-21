package b800varios.E805AnillamientoConFicheros;

import java.io.*;
import java.util.Scanner;

public class E805AnillamientoConFicheros {
    static void main(String[] args) {
        Scanner entrada = null;
        PrintWriter salida = null;

        try {
            entrada = new Scanner(new BufferedReader(new FileReader("src/b800varios/E805AnillamientoConFicheros/entrada.txt")));
            salida = new PrintWriter(new BufferedWriter(new FileWriter("src/b800varios/E805AnillamientoConFicheros/salida.txt")));
            int campanna;

            while (entrada.hasNextInt()) {
                campanna = entrada.nextInt();
                if (campanna == 0) break;

                int totales = 0;

                for (int i = 0; i < campanna; i++) {
                    int capt = entrada.nextInt();
                    int reg = entrada.nextInt();
                    totales += (capt - reg);
                }
                salida.println(totales);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
        }
    }
}