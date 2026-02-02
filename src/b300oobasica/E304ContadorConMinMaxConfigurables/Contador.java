package b300oobasica.E304ContadorConMinMaxConfigurables;

public class Contador {
    private static final int POR_DEFECTO = 50;

    private int valor;
    private int paso = 1;
    private boolean redondeo = false;

    private int minimo = 1;
    private int maximo = 100;

    public Contador() {
        setValor(POR_DEFECTO);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public Contador(int valor, int paso, int minimo, int maximo) {
        setMinimo(minimo);
        setMaximo(maximo);
        setPaso(paso);
        setValor(valor);
    }

    public Contador(int valor, int paso, boolean redondeo) {
        setPaso(paso);
        setRedondeo(redondeo);
        setValor(valor);
    }

    public String toString() {
        return "Valgo " + valor + (redondeo ? " r" : "");
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int nuevoValor) {
        if (redondeo) {
            nuevoValor = (nuevoValor / paso) * paso;
        }

        if (nuevoValor < minimo) {
            valor = minimo;
        } else if (nuevoValor > maximo) {
            valor = maximo;
        } else {
            valor = nuevoValor;
        }
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        if (paso < 1) paso = 1;
        this.paso = paso;
        setValor(valor); // reajuste
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        if (minimo < 1) minimo = 1;
        this.minimo = minimo;

        if (maximo < minimo) {
            maximo = minimo;
        }
        setValor(valor);
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        if (maximo < minimo) {
            maximo = minimo;
        }
        this.maximo = maximo;
        setValor(valor);
    }

    public boolean isRedondeo() {
        return redondeo;
    }

    public void setRedondeo(boolean redondeo) {
        this.redondeo = redondeo;
        setValor(valor);
    }

    public void resetear() {
        setValor(POR_DEFECTO);
    }

    public void incrementar() {
        setValor(valor + paso);
    }

    public void incrementar(int incremento) {
        setValor(valor + incremento);
    }

    public void decrementar() {
        setValor(valor - paso);
    }

    public void decrementar(int decremento) {
        setValor(valor - decremento);
    }
}