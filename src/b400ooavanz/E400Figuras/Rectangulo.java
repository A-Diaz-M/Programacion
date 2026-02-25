package b400ooavanz.E400Figuras;

public class Rectangulo extends Figura {

    protected double lado1;
    protected double lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }
}