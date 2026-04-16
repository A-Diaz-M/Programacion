package b800varios.E803DuplicarValorConFicheros;

import java.io.*;
import java.util.Scanner;

public class E803DuplicarValorConFicheros {
    static void main(String[] args) {
        PrintWriter salida = null;
        Scanner entrada = null;

        try {
            entrada = new Scanner(new BufferedReader(new FileReader("src/b800varios/E803DuplicarValorConFicheros/Entrada.txt")));
            salida = new PrintWriter(new BufferedWriter(new FileWriter("src/b800varios/E803DuplicarValorConFicheros/datos.txt")));

            while (entrada.hasNext()) {
                int numero = entrada.nextInt();
                salida.println(numero*2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
        }
    }
}
