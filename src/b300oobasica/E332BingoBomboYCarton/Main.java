package b300oobasica.E332BingoBomboYCarton;

public class Main {
    static void main(String[] args) {
        Bombo b = new Bombo(50);
        Carton c = new Carton(20, b);

        while (!c.hayBingo()) {
            int bola = b.dameBola();
            System.out.println("Sale bola: " + bola);
            c.anotaBola(bola);
            System.out.println(c);
        }

        System.out.println("¡BINGO!");
    }
}