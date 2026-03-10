package b400ooavanz.E404FigurasComparables;

public abstract class Figura implements Comparable<Figura> {
    public abstract double calcularArea();

    public abstract String toString();


    @Override
    public int compareTo(Figura otra) {
        double diferencia = this.calcularArea() - otra.calcularArea();

        if (diferencia < 0) return -1;
        else if (diferencia > 0) return 1;
        else return 0;
    }
}