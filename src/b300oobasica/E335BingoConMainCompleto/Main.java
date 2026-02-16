package b300oobasica.E335BingoConMainCompleto;

public class Main {
    static void main(String[] args) {
        Bombo bombo = new Bombo(50);
        Carton[] cartones = new Carton[5];

        for (int i = 0; i < cartones.length; i++) {
            cartones[i] = new Carton(20, bombo);
        }

        boolean hayBingo = false;

        while (!hayBingo) {
            int bola = bombo.dameBola();
            System.out.println("Sale bola: " + bola);

            for (int i = 0; i < cartones.length; i++) {
                cartones[i].anotaBola(bola);

                if (cartones[i].hayBingo()) {
                    hayBingo = true;
                    System.out.printf("¡BINGO del cartón %d!\n", i + 1);
                    break;
                }
            }
        }
    }
}