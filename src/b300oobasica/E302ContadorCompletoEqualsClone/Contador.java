package b300oobasica.E302ContadorCompletoEqualsClone;

public class Contador {
    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int RESET = 50;
    private static final int PASO = 5;

    private int valor = 0;
    private String etiqueta = "unidades";

    public Contador() {
        setValor(MIN);
    }

    public Contador(int valor) {
        setValor(valor);
    }

    public Contador(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Contador(int valor, String etiqueta) {
        setValor(valor);
        this.etiqueta = etiqueta;
    }

    public String toString() {
        return "Valgo: " + valor + " " + etiqueta;
    }

    public Contador clone() {
        return new Contador(this.valor, this.etiqueta);

    }

    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof Contador)) return false;

        Contador otro = (Contador) obj;
        return (this.valor == otro.valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        if (valor > MAX) this.valor = 100;
        else if (valor < MIN) this.valor = 0;
        else this.valor = valor;
        //valor = Math.min(Math.max(valor,0),100);
    }

    public void resetear() {
        valor = RESET;
    }

    public void incrementar(int veces) {
        setValor(valor + veces);
    }

    public void incrementar() {
        setValor(valor + 1);
    }

    public void decrementar(int veces) {
        setValor(valor - veces);
    }

    public void decrementar() {
        setValor(valor - 1);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
}