package b400ooavanz.E404FigurasComparables;

public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        super(lado, lado);
    }

    public String toString() {
        return "Cuadrado, lado = " + getLado() + ", area = " + calcularArea();
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        this.base = lado;
        this.altura = lado;
    }
}