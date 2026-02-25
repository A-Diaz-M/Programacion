package b400ooavanz.E400Figuras;

public class Main {
    static void main(String[] args) {

        Figura[] figuras = new Figura[5];

        figuras[0] = new Circulo(3);
        figuras[1] = new Rectangulo(4, 5);
        figuras[2] = new Cuadrado(4);
        figuras[3] = new Circulo(2.5);
        figuras[4] = new Rectangulo(2, 6);

        double areaTotal = 0;

        for (Figura f : figuras) {
            areaTotal += f.calcularArea();
        }

        System.out.println("Área total de todas las figuras: " + areaTotal);
    }
}