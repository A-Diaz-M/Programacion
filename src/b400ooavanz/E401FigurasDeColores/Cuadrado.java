package b400ooavanz.E401FigurasDeColores;

public class Cuadrado extends Rectangulo {
    public Cuadrado(double lado, String color) {
        super(lado, lado, color);
    }

    public String toString() {
        return String.format(super.toString(), "Cuadrado con lado" + getBase());
    }

    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        this.base = lado;
        this.altura = lado;
    }
}