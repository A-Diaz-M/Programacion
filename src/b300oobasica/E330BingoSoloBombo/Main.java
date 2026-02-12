package b300oobasica.E330BingoSoloBombo;

public class Main {
    static void main(String[] args) {

        Bombo bombo = new Bombo(10);

        System.out.println(bombo);

        for (int i = 0; i < 5; i++) {
            int bola = bombo.dameBola();
            System.out.println("Ha salido la bola: " + bola);
        }

        System.out.println("\nEstado del bombo:");
        System.out.println(bombo);
    }
}