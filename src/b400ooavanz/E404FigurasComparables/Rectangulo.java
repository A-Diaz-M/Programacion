package b400ooavanz.E404FigurasComparables;

public class Rectangulo extends Figura {

    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public String toString() {
        return "Rectangulo, base = " + base + ", altura = " + altura + ", area = " + calcularArea();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}